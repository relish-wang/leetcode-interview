package struct

class ClassExecutor {


    fun parseCommand(
        methodsStr: String,
        paramsStr: String
    ) {
        val methods = parseMethods(methodsStr)
        val params = parseArrayOfIntArray(paramsStr)
        parseCommand(methods, params)
    }

    fun parseCommand(
        methods: Array<String>,
        params: Array<Array<*>>
    ) {
        val n = methods.size
        val className = methods[0]
        val constructorParams = params[0]
        val clazz = Class.forName(className)
        val constructor = clazz.declaredConstructors.first()
        val instance = if (constructorParams.isEmpty()) {
            constructor.newInstance()
        } else {
            constructor.newInstance(constructorParams[0])
        }
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

    companion object {
        fun parseMethods(raw: String): Array<String> {
            return raw.substring(1, raw.length - 1).split(",").toTypedArray()
        }

        fun parseArrayOfIntArray(raw: String): Array<Array<*>> {
            val arr = raw.substring(2, raw.length - 2).split(Regex("], *\\["))
            val n = arr.size
            return Array(n) { i ->
                val s = arr[i]
                if (s.isEmpty()) {
                    arrayOf<Int>()
                } else {
                    s.split(Regex(", *")).takeIf { it.isNotEmpty() }?.map {
                        it.trim().toInt()
                    }?.toTypedArray() ?: arrayOf<Int>()
                }
            }
        }
    }
}