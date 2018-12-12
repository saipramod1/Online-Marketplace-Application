JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \ AbstractClass.java \ AbstractFactory.java \ AdminDispatcher.java \ AdminView.java \ AuthorizationException.java \ AuthorizationInvocationHandler.java \ BestSale.java \ BestSaleClient.java \ BestSaleServer.java \ BestSaleView.java \ ClientDispatcher.java \ CommandInterface.java \ Dispatcher.java \ FrontController.java \ Invoker.java \ PageReturn.java \ Registration.java \ RequiresRole.java \ ServerImpl.java \  Session.java \ User.java \


classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class