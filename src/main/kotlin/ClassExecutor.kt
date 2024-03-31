class ClassExecutor {

    fun parseCommand(
        methods: Array<String>,
        params: Array<Array<*>>
    ) {
        val n = methods.size
        val className = methods[0]
        val constructorParams = params[0]
        val clazz = Class.forName(className)
        val constructor = clazz.getDeclaredConstructor(Int::class.java)
        val instance = constructor.newInstance(constructorParams[0])
        val result = mutableListOf<String>()
        if (instance != null) {
            result.add("null")
        }
        for (i in 1 until n) {
            val obj = invokeMethod(clazz, instance, methods[i], params[i], params[i].map {
                it!!.javaClass.takeIf { it != Integer::class.java } ?: Int::class.java
            }.toTypedArray())
            result.add(obj?.toString() ?: "null")
        }
        println(result.toTypedArray().contentToString())
    }

    fun invokeMethod(
        clazz: Class<*>,
        obj: Any,
        methodName: String,
        params: Array<*>,
        parameterTypes: Array<Class<*>>
    ): Any? {
        val method = clazz.getDeclaredMethod(methodName, *parameterTypes)
        method.isAccessible = true
        return method.invoke(obj, *params)
    }
}