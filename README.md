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
