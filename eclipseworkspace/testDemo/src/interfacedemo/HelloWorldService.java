package interfacedemo;
interface HelloWorld {
    public void sayHello();
}
 
// Class implements HelloWorld
 class SpringHelloWorld implements HelloWorld {
   public void sayHello()  {
           System.out.println("Spring say Hello!");
   }
}
 
// Other class implements HelloWorld
 class StrutsHelloWorld implements HelloWorld {
   public void sayHello()  {
           System.out.println("Struts say Hello!");
   }
}
 
 
// And Service class
public class HelloWorldService {
    
     // Field type HelloWorld
     private HelloWorld helloWorld;
    
     // Constructor HelloWorldService
     // It initializes the values for the field 'helloWorld'
     public HelloWorldService()  {
           this.helloWorld = new StrutsHelloWorld();
     }
     public static void main(String[] args) {
		HelloWorldService a = new HelloWorldService();
		a.helloWorld.sayHello();
		
	}
 
}