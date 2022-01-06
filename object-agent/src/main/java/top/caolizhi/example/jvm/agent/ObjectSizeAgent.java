package top.caolizhi.example.jvm.agent;

import java.lang.instrument.Instrumentation;

public class ObjectSizeAgent {
	private static Instrumentation inst;

	public ObjectSizeAgent() {}

	public static void premain(String agentArgs, Instrumentation _inst) {
		inst = _inst;
	}

	public static long sizeOf(Object o) {
		return inst.getObjectSize(o);
	}
}

