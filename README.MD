[ ![Download](https://api.bintray.com/packages/tinyfish/maven/statemanager/images/download.svg) ](https://bintray.com/tinyfish/maven/statemanager/_latestVersion)

# StateManager

标签（空格分隔）： Android

---

## Gradle
```groovy
dependencies {
    compile 'com.alipictures:statemanager:1.0.0'
}
```
## Maven
```xml
<dependency>
  <groupId>com.alipictures</groupId>
  <artifactId>statemanager</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```
## Usage
```java
mStateLayout.showState("loading_state");
```



## 是什么？

更加方便的加载各种状态,各个状态事件的回调，支持在Theme里面设置对应状态样式

包含了Loading状态，Exception状态，Net Error状态，EmptyData状态及核心态，通过调用showState()方法，可以方便的显示各种状态

## 特性

1. 只有在显示对应状态的时候，才会加载View(需要提前注册好各种需要的状态)
2. 支持定制各种状态的文案及视觉
3. 支持拓展自己的状态
4. 支持局部或者全局显示各种状态
5. 支持Activity、Fragment、Layout及帮助类的方式
6. 支持在RecyclerView中单个Item变换各种状态

## 用法

### 1. StateLayout

这是一个自定义布局容器，可以直接在xml文件中使用

### 2. StateManagerActivity

需要继承StateManagerActivity,其余流程保持不变

### 2. StateManagerFragment

需要实现getLayoutId(),返回对应的布局资源，在initViewContent()方法中，初始化UI，其余流程保持不变


## 其他

1. 在某些情况下，replaceFragment觉得太重了，可以直接实现一个State，来显示对应的业务，更加的轻量级





