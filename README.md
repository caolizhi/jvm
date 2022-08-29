## JVM

### jdk1.8 class 

#### file format
![img.png](images/jdk_1.8_class_format.png)

`javap -v Bytecode01.class`

```
classfile {
   u4 magic;
   u2 minor_version;
   u2 major_version;
   u2 constant_pool_count; // 16 个，但是 0 保留，所以只有 15 个
   cp_info constant_pool[constant_pool_count - 1]
   u2
}
```

### JMM

#### volatile 底层实现
1. 字节码层级
![img.png](images/volatile_bytecode.png)
2. JVM层级
3. OS和硬件层级

#### synchronized 底层实现
1. 字节码层级
![img_1.png](images/synchronized_bytecode.png)
2. JVM层级
3. OS和硬件层级

#### 对象分配过程
![img_2.png](images/object_assign1.png)
