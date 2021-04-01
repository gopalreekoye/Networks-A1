JC = javac
.SUFFIXES: .java .class

BIN=bin
SRC=src

$(BIN)/%.class:$(SRC)/%.java
	$(JC) -d $(BIN)/ -cp $(BIN)/ $<


CLASSES=Client.class Server.class
CLASS_FILES = $(CLASSES:%.class=$(BIN)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BIN)/*.class


startServer: 
	java -cp bin/ Server

startClient:
	java -cp bin/ Client



