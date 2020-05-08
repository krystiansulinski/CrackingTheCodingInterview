package Q13_1_Private_Constructor;

public class OuterClass {
	OuterClass() {
		InnerClassA a = new InnerClassA();
	}

	class InnerClassA {
		private InnerClassA() {
		}

		class InnerInnerClassB extends InnerClassA {
		}
	}

	class InnerClassB extends InnerClassA {
	}
}