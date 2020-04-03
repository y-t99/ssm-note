# 一、Transaction Management

[博客](https://juejin.im/post/5b00c52ef265da0b95276091)

## 1、简介

**所谓事务管理，其实就是“按照给定的事务规则来执行提交或者回滚操作”。**

### 接口介绍

**PlatformTransactionManager**

Spring提供`PlatformTransactionManager`接口，自己不是实现事务管理，而是交由厂商实现（类似java的sql）。常用的事务管理器有DataSourceTransactionManager（作用于JDBC和IBatis）。

```java
Public interface PlatformTransactionManager()...{  
    // Return a currently active transaction or create a new one, according to the specified propagation behavior（根据指定的传播行为，返回当前活动的事务或创建一个新事务。）
    TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException; 
    // Commit the given transaction, with regard to its status（使用事务目前的状态提交事务）
    Void commit(TransactionStatus status) throws TransactionException;  
    // Perform a rollback of the given transaction（对执行的事务进行回滚）
    Void rollback(TransactionStatus status) throws TransactionException;  
} 
```

**TransactionDefinition**

事务的一些基本配置，描述了事务策略如何应用到方法上。

```java
public interface TransactionDefinition {
    // 返回事务的传播行为, 解决业务层方法之间互相调用的事务问题。
    int getPropagationBehavior(); 
    // 返回事务的隔离级别，解决并发事务带来的问题 。
    int getIsolationLevel(); 
    // 返回事务必须在多少秒内完成。
    int getTimeout(); 
    //返回事务的名字。
    String getName()；
    // 返回是否优化为只读事务。
    boolean isReadOnly();
} 
```

**TransactionStatus**

记录事务的状态 该接口定义了一组方法,用来获取或判断事务的相应状态信息。

```java
public interface TransactionStatus{
    boolean isNewTransaction(); // 是否是新的事物
    boolean hasSavepoint(); // 是否有恢复点
    void setRollbackOnly();  // 设置为只回滚
    boolean isRollbackOnly(); // 是否为只回滚
    boolean isCompleted; // 是否已完成
} 
```

### 特点

* 对于不同的事务apis，提供统一的语法形式。Java Transaction API (JTA), JDBC, Hibernate, and the Java Persistence API (JPA)。
* API简单

The `TransactionStatus` interface provides a simple way for transactional code to control transaction execution and query transaction status. 

## 2、Transaction Management 声明式

### 原理

Spring事务管理是通过Spring AOP实现的。

Spring通过一个`TransactionInterceptor`、一个 `PlatformTransactionManager` 实现和transactional metadata生成一个代理对象，达到对方法调用的事务增强。

![](./img/spring-tx.png)

### 回滚

* Spring的事务管理默认下只对运行时异常进行处理，遇到声明式异常不进行事务回滚。
* `no-rollback-for`某个发生异常，不进行事务回滚。

```xml
<tx:method name="errorMethod" no-rollback-for="XxxException"/>
```

* `rollback-for`某异常发生，进行事务回滚。

```java
<tx:method name="*" rollback-for="Throwable"/>
```

* 编程式回滚事务

```java
public void resolvePosition() {
    try {
        // some business logic...
    } catch (NoProductInStockException ex) {
        // trigger rollback programmatically
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
```

### 事务增强

```xml
<tx:advice>
    <tx:attributes>
    	<tx:method name="" [propagation="" isolation="" timeout="" read-only="" rollback-for="" no-rollback-for=""]/>
    </tx:attributes>
</tx:advice>
```

### 注解

* **@Transactional** 注在需要事务管理的类或者方法上上。

> 相当于<tx:advice />
>
> 使用代理时， `@Transactional` 仅对公共方法产生影响。 
>
>  `@Transactional` 并不会让类或方法有事务行为，他的作用仅仅是提供事务属性等元数据。
>
>  `@Transactional` 在接口上注释（尽管这并不提倡），代理发生时，只有在jdk模式下的代理，注解才会有效。
>
> 自调用 `@Transactional` 注释的方法将无效，且代理必须完全构造完才使用，而不依赖 `@PostConstruct`这些特性。

> `@EnableTransactionManagement` and `` looks for `@Transactional` only on beans in the same application context in which they are defined. This means that, if you put annotation-driven configuration in a `WebApplicationContext` for a `DispatcherServlet`, it checks for `@Transactional` beans only in your controllers and not your services. See [MVC](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/web.html#mvc-servlet) for more information.

* **@EnableTransactionManagement** 让bean具有事务管理的功能。

> 相当于 

### 其他

[**@Transactional的使用**](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html#transaction-declarative-annotations)

[**Transaction隔离级别介绍**](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html#tx-propagation)

[**在事务增强之上进行增强**](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html#transaction-declarative-applying-more-than-just-tx-advice)

## 3、Transaction编程式

[programmatic transaction management](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html#transaction-programmatic)

[Choosing Between Programmatic and Declarative Transaction Management](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html#tx-decl-vs-prog)

## 4、其他

[Transaction-bound Events](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html#transaction-event)

