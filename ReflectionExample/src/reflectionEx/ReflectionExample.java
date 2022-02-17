package reflectionEx;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionExample {
	public static void main(String[] args) {

		// Obtain the class object if we know the name of the class
		Class<RentCar> rental = RentCar.class;
		try {
			

			// get the simple name of the class (without package info)
			String rentalClassNoPackage = rental.getSimpleName();
			System.out.println("Class Name without package is: "
					+ rentalClassNoPackage);

			
			// get all the constructors of the class
			Constructor<?>[] constructors = rental.getConstructors();
			System.out.println("Constructors are: "
					+ Arrays.toString(constructors));

			// get constructor with specific argument
			Constructor<?> constructor = rental.getConstructor(Integer.TYPE);

			// initializing an object of the RentCar class
			// 455 is the parameter sent 
			RentCar rent = (RentCar) constructor.newInstance(455);

			// get all methods declared in the class
			// but excludes inherited methods.
			Method[] declaredMethods = rental.getDeclaredMethods();
			System.out.println("Declared Methods are: "
					+ Arrays.toString(declaredMethods));
			for (Method dmethod : declaredMethods) {
				System.out.println("Declared method = " + dmethod.getName());
			}

			// get method with specific name and parameters
			Method oneMethod = rental.getMethod("computeRentalCost",
					new Class[] { Integer.TYPE });
			System.out.println("Method is: " + oneMethod);
			
			
			// call computeRentalCost method with parameter int
			System.out.println("Invoking computeRentalCost method from RentCar.java");
			oneMethod.invoke(rent, 4);

			Annotation[] annos = oneMethod.getAnnotations();
			System.out.println(Arrays.toString(annos));
			for(Annotation annotation : annos) {
				System.out.println(annotation);
			}
            
		

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
