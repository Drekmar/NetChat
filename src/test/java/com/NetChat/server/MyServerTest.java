package com.NetChat.server;

import com.sun.deploy.nativesandbox.NativeSandboxOutputStream;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.MockedConstruction;
import org.mockito.MockedConstruction.Context;
import org.mockito.Spy;
import sun.security.action.GetPropertyAction;
import sun.security.x509.AttributeNameEnumeration;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class MyServerTest {
    @InjectMocks
    private MyServer myServer;

    @Spy
    private Vector vectorSpy;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.NetChat.server.MyServer.broadcastclientslist

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method broadcastclientslist()

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link java.util.NoSuchElementException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("broadcastclientslist: for(ClientHandler o: clients) -> ThrowNoSuchElementException")
    public void testBroadcastclientslist_ThrowNoSuchElementException() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", -256);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastclientslist] produces [java.util.NoSuchElementException]
            java.util.Vector$Itr.next(Vector.java:1174)
            com.NetChat.server.MyServer.broadcastclientslist(MyServer.java:132) */
        myServer.broadcastclientslist();
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link ClassCastException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("broadcastclientslist: for(ClientHandler o: clients) -> ThrowClassCastException")
    public void testBroadcastclientslist_ThrowClassCastException() throws Exception {
        Stack stack = ((Stack) createInstance("java.util.Stack"));
        Object[] elementData = new Object[1];
        Object object = createInstance("java.lang.Object");
        elementData[0] = object;
        setField(stack, "java.util.Vector", "elementData", elementData);
        setField(stack, "java.util.Vector", "elementCount", 1);
        setField(stack, "java.util.AbstractList", "modCount", 1);
        setField(myServer, "com.NetChat.server.MyServer", "clients", stack);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastclientslist] produces [java.lang.ClassCastException: java.lang.Object cannot be cast to com.NetChat.server.ClientHandler]
            com.NetChat.server.MyServer.broadcastclientslist(MyServer.java:132) */
        myServer.broadcastclientslist();
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link ArrayIndexOutOfBoundsException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("broadcastclientslist: for(ClientHandler o: clients) -> ThrowArrayIndexOutOfBoundsException")
    public void testBroadcastclientslist_ThrowArrayIndexOutOfBoundsException() throws Exception {
        Vector vector = ((Vector) createInstance("java.util.Vector"));
        Object[] elementData = {};
        setField(vector, "java.util.Vector", "elementData", elementData);
        setField(vector, "java.util.Vector", "elementCount", 1);
        setField(vector, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", vector);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastclientslist] produces [java.lang.ArrayIndexOutOfBoundsException: 0]
            java.util.Vector.elementData(Vector.java:739)
            java.util.Vector$Itr.next(Vector.java:1176)
            com.NetChat.server.MyServer.broadcastclientslist(MyServer.java:132) */
        myServer.broadcastclientslist();
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     * @utbot.invokes {@link Vector#iterator()}
     * @utbot.throwsException {@link NullPointerException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("broadcastclientslist: for(ClientHandler o: clients) -> ThrowNullPointerException")
    public void testBroadcastclientslist_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "clients", null);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastclientslist] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.broadcastclientslist(MyServer.java:132) */
        myServer.broadcastclientslist();
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link NullPointerException} in: sb.append(o.getName() + " ");
     */
    @Test
    @DisplayName("broadcastclientslist: sb.append(o.getName() + \" \") : True -> ThrowNullPointerException")
    public void testBroadcastclientslist_ThrowNullPointerException_1() throws Exception {
        Vector vector = ((Vector) createInstance("java.util.Vector"));
        Object[] elementData = {null};
        setField(vector, "java.util.Vector", "elementData", elementData);
        setField(vector, "java.util.Vector", "elementCount", 1);
        setField(vector, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", vector);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastclientslist] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.broadcastclientslist(MyServer.java:133) */
        myServer.broadcastclientslist();
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method broadcastclientslist()

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     */
    @Test
    @DisplayName("broadcastclientslist: ")
    public void testBroadcastclientslist() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MAX_VALUE);
        setField(myServer, "com.NetChat.server.MyServer", "server", null);

        myServer.broadcastclientslist();
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     */
    @Test
    @DisplayName("broadcastclientslist: ")
    public void testBroadcastclientslist1() {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("/clients ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("#$\\\"'");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);

        myServer.broadcastclientslist();
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     */
    @Test
    @DisplayName("broadcastclientslist: ")
    public void testBroadcastclientslist2() {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("\n\t\r");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("\n\t\r");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("\n\t\r");
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        (when(clientHandlerMock3.getName())).thenReturn(" ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock3))).sendMsg(any());
        vectorSpy.add(clientHandlerMock3);
        ClientHandler clientHandlerMock4 = mock(ClientHandler.class);
        (when(clientHandlerMock4.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(clientHandlerMock4))).sendMsg(any());
        vectorSpy.add(clientHandlerMock4);

        myServer.broadcastclientslist();
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastclientslist()}
     */
    @Test
    @DisplayName("broadcastclientslist: ")
    public void testBroadcastclientslist3() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn(" ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("XZ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MAX_VALUE);

        myServer.broadcastclientslist();
    }
    ///endregion

    ///region OTHER: SUCCESSFUL EXECUTIONS for method broadcastclientslist()

    @Test
    public void testBroadcastclientslist4() throws Exception {
        Vector vector = ((Vector) createInstance("java.util.Vector"));
        Object[] elementData = new Object[9];
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn(((String) null));
        elementData[0] = ((Object) clientHandlerMock);
        String string = "";
        elementData[1] = ((Object) string);
        elementData[2] = ((Object) string);
        elementData[3] = ((Object) string);
        elementData[4] = ((Object) string);
        elementData[5] = ((Object) string);
        elementData[6] = ((Object) string);
        elementData[7] = ((Object) string);
        elementData[8] = ((Object) string);
        setField(vector, "java.util.Vector", "elementData", elementData);
        setField(vector, "java.util.Vector", "elementCount", 1);
        setField(myServer, "com.NetChat.server.MyServer", "clients", vector);

        myServer.broadcastclientslist();
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.NetChat.server.MyServer.broadcastMsg

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method broadcastMsg(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     * @utbot.invokes {@link Vector#iterator()}
     */
    @Test
    @DisplayName("broadcastMsg: -> VectorIterator")
    public void testBroadcastMsg_VectorIterator() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        setField(attributeNameEnumeration, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);

        myServer.broadcastMsg(null);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method broadcastMsg(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link ClassCastException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("broadcastMsg: for(ClientHandler o: clients) -> ThrowClassCastException")
    public void testBroadcastMsg_ThrowClassCastException() throws Exception {
        Vector vector = ((Vector) createInstance("java.util.Vector"));
        Object[] elementData = new Object[1];
        Object object = createInstance("java.lang.Object");
        elementData[0] = object;
        setField(vector, "java.util.Vector", "elementData", elementData);
        setField(vector, "java.util.Vector", "elementCount", 1);
        setField(vector, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", vector);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastMsg] produces [java.lang.ClassCastException: java.lang.Object cannot be cast to com.NetChat.server.ClientHandler]
            com.NetChat.server.MyServer.broadcastMsg(MyServer.java:99) */
        myServer.broadcastMsg(null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link ArrayIndexOutOfBoundsException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("broadcastMsg: for(ClientHandler o: clients) -> ThrowArrayIndexOutOfBoundsException")
    public void testBroadcastMsg_ThrowArrayIndexOutOfBoundsException() throws Exception {
        Stack stack = ((Stack) createInstance("java.util.Stack"));
        Object[] elementData = {};
        setField(stack, "java.util.Vector", "elementData", elementData);
        setField(stack, "java.util.Vector", "elementCount", 1);
        setField(stack, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", stack);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastMsg] produces [java.lang.ArrayIndexOutOfBoundsException: 0]
            java.util.Vector.elementData(Vector.java:739)
            java.util.Vector$Itr.next(Vector.java:1176)
            com.NetChat.server.MyServer.broadcastMsg(MyServer.java:99) */
        myServer.broadcastMsg(null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     * @utbot.invokes {@link Vector#iterator()}
     * @utbot.throwsException {@link NullPointerException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("broadcastMsg: for(ClientHandler o: clients) -> ThrowNullPointerException")
    public void testBroadcastMsg_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "clients", null);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastMsg] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.broadcastMsg(MyServer.java:99) */
        myServer.broadcastMsg(null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link NullPointerException} in: o.sendMsg(msg);
     */
    @Test
    @DisplayName("broadcastMsg: o.sendMsg(msg) : True -> ThrowNullPointerException")
    public void testBroadcastMsg_ThrowNullPointerException_1() throws Exception {
        Stack stack = ((Stack) createInstance("java.util.Stack"));
        Object[] elementData = {null};
        setField(stack, "java.util.Vector", "elementData", elementData);
        setField(stack, "java.util.Vector", "elementCount", 1);
        setField(stack, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", stack);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastMsg] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.broadcastMsg(MyServer.java:100) */
        myServer.broadcastMsg(null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method broadcastMsg(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     */
    @Test
    @DisplayName("broadcastMsg: msg = 'Z\u008E' (mutated from 'Z')")
    public void testBroadcastMsgWithNonEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "PORT", 0);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);

        myServer.broadcastMsg("Z\u008E");
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     */
    @Test
    @DisplayName("broadcastMsg: msg = ''")
    public void testBroadcastMsgWithEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MIN_VALUE);
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);

        myServer.broadcastMsg("");
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#broadcastMsg(String)}
     */
    @Test
    @DisplayName("broadcastMsg: msg = '3-'")
    public void testBroadcastMsgWithNonEmptyString1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock3))).sendMsg(any());
        vectorSpy.add(clientHandlerMock3);
        ClientHandler clientHandlerMock4 = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock4))).sendMsg(any());
        vectorSpy.add(clientHandlerMock4);
        setField(myServer, "com.NetChat.server.MyServer", "server", null);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MIN_VALUE);
        setField(myServer, "com.NetChat.server.MyServer", "out", null);

        myServer.broadcastMsg("3-");
    }
    ///endregion

    ///region OTHER: SUCCESSFUL EXECUTIONS for method broadcastMsg(java.lang.String)

    @Test
    public void testBroadcastMsg1() throws Exception {
        Stack stack = ((Stack) createInstance("java.util.Stack"));
        Object[] elementData = new Object[9];
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        elementData[0] = ((Object) clientHandlerMock);
        setField(stack, "java.util.Vector", "elementData", elementData);
        setField(stack, "java.util.Vector", "elementCount", 1);
        setField(myServer, "com.NetChat.server.MyServer", "clients", stack);

        myServer.broadcastMsg(null);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method broadcastMsg(java.lang.String)

    @Test
    public void testBroadcastMsg2() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", -2147483647);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);
        
        /* This test fails because method [com.NetChat.server.MyServer.broadcastMsg] produces [java.util.NoSuchElementException]
            java.util.Vector$Itr.next(Vector.java:1174)
            com.NetChat.server.MyServer.broadcastMsg(MyServer.java:99) */
        myServer.broadcastMsg(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.NetChat.server.MyServer.getAuthService

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getAuthService()

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#getAuthService()}
     * @utbot.returnsFrom {@code return authService;}
     */
    @Test
    @DisplayName("getAuthService: -> return authService")
    public void testGetAuthService_ReturnAuthService() throws Exception {
        BaseAuthService baseAuthService = ((BaseAuthService) createInstance("com.NetChat.server.BaseAuthService"));
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);

        BaseAuthService actual = ((BaseAuthService) myServer.getAuthService());

        ArrayList actualEntries = ((ArrayList) getFieldValue(actual, "com.NetChat.server.BaseAuthService", "entries"));
        assertNull(actualEntries);

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.NetChat.server.MyServer.history

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method history(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#history(String)}
     * @utbot.invokes {@link java.util.Calendar#getInstance()}
     * @utbot.throwsException {@link NullPointerException} in: out.println(Calendar.getInstance().getTime().toString() + " " + msg);
     */
    @Test
    @DisplayName("history: out.println(Calendar.getInstance().getTime().toString() + \" \" + msg) : True -> ThrowNullPointerException")
    public void testHistory_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        MockedConstruction mockedConstruction = null;
        try {
            mockedConstruction = mockConstruction(GetPropertyAction.class, (GetPropertyAction getPropertyActionMock, Context context) -> {
            });
            setField(myServer, "com.NetChat.server.MyServer", "out", null);
            
            /* This test fails because method [com.NetChat.server.MyServer.history] produces [java.lang.NullPointerException]
                com.NetChat.server.MyServer.history(MyServer.java:86) */
            myServer.history(null);
        } finally {
            mockedConstruction.close();
        }
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method history(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#history(String)}
     */
    @Test
    @DisplayName("history: msg = ''")
    public void testHistoryWithEmptyString() throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        NativeSandboxOutputStream nativeSandboxOutputStreamMock = mock(NativeSandboxOutputStream.class);
        (((NativeSandboxOutputStream) (doNothing()).when(nativeSandboxOutputStreamMock))).write(any(), anyInt(), anyInt());
        (((OutputStream) (doNothing()).when(nativeSandboxOutputStreamMock))).flush();
        PrintWriter printWriter = new PrintWriter(nativeSandboxOutputStreamMock, false);
        setField(myServer, "com.NetChat.server.MyServer", "out", printWriter);

        myServer.history("");
    }
    ///endregion

    ///region FUZZER: ERROR SUITE for method history(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#history(String)}
     */
    @Test
    @DisplayName("history: msg = '\u00A1s' (mutated from '\u00A1') -> throw NullPointerException")
    public void testHistoryThrowsNPEWithNonEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        FilterOutputStream filterOutputStream = new FilterOutputStream(null);
        PrintWriter printWriter = new PrintWriter(filterOutputStream, false);
        setField(myServer, "com.NetChat.server.MyServer", "out", printWriter);
        
        /* This test fails because method [com.NetChat.server.MyServer.history] produces [java.lang.NullPointerException]
            java.io.FilterOutputStream.write(FilterOutputStream.java:77)
            java.io.FilterOutputStream.write(FilterOutputStream.java:125)
            sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
            sun.nio.cs.StreamEncoder.implFlushBuffer(StreamEncoder.java:291)
            sun.nio.cs.StreamEncoder.implFlush(StreamEncoder.java:295)
            sun.nio.cs.StreamEncoder.flush(StreamEncoder.java:141)
            java.io.OutputStreamWriter.flush(OutputStreamWriter.java:229)
            java.io.BufferedWriter.flush(BufferedWriter.java:254)
            java.io.PrintWriter.flush(PrintWriter.java:320)
            com.NetChat.server.MyServer.history(MyServer.java:87) */
        myServer.history("\u00A1s");
    }
    ///endregion

    ///region FUZZER: TIMEOUTS for method history(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#history(String)}
     */
    @Test
    @DisplayName("history: msg = '\n\t'")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testHistoryWithBlankString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MAX_VALUE);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock);
        StringWriter stringWriter = new StringWriter(2013265919);
        PrintWriter printWriter = new PrintWriter(stringWriter);
        setField(myServer, "com.NetChat.server.MyServer", "out", printWriter);
        InetAddress inetAddressMock = mock(InetAddress.class);
        ServerSocket serverSocket = new ServerSocket(-1, Integer.MIN_VALUE, inetAddressMock);
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> myServer.history("\n\t"));
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#history(String)}
     */
    @Test
    @DisplayName("history: msg = '\n\t!' (mutated from '\n\t')")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testHistoryWithNonEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MAX_VALUE);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock);
        StringWriter stringWriter = new StringWriter(2013265919);
        PrintWriter printWriter = new PrintWriter(stringWriter);
        setField(myServer, "com.NetChat.server.MyServer", "out", printWriter);
        InetAddress inetAddressMock = mock(InetAddress.class);
        ServerSocket serverSocket = new ServerSocket(-1, Integer.MIN_VALUE, inetAddressMock);
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> myServer.history("\n\t!"));
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method history(java.lang.String)

    @Test
    public void testHistory1() throws Exception {
        MockedConstruction mockedConstruction = null;
        try {
            mockedConstruction = mockConstruction(GetPropertyAction.class, (GetPropertyAction getPropertyActionMock, Context context) -> {
            });
            PrintWriter anonymousPrintWriter = ((PrintWriter) createInstance("java.io.Console$3"));
            setField(myServer, "com.NetChat.server.MyServer", "out", anonymousPrintWriter);
            String msg = "";
            
            /* This test fails because method [com.NetChat.server.MyServer.history] produces [java.lang.NullPointerException]
                java.io.PrintWriter.println(PrintWriter.java:738)
                com.NetChat.server.MyServer.history(MyServer.java:86) */
            myServer.history(msg);
        } finally {
            mockedConstruction.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.NetChat.server.MyServer.isNickBusy

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method isNickBusy(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     * @utbot.invokes {@link Vector#iterator()}
     * @utbot.returnsFrom {@code return false;}
     */
    @Test
    @DisplayName("isNickBusy: VectorIterator -> return false")
    public void testIsNickBusy_VectorIterator() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        setField(attributeNameEnumeration, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);

        boolean actual = myServer.isNickBusy(null);

        assertFalse(actual);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method isNickBusy(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link ClassCastException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("isNickBusy: for(ClientHandler o: clients) -> ThrowClassCastException")
    public void testIsNickBusy_ThrowClassCastException() throws Exception {
        Vector vector = ((Vector) createInstance("java.util.Vector"));
        Object[] elementData = new Object[1];
        Object object = createInstance("java.lang.Object");
        elementData[0] = object;
        setField(vector, "java.util.Vector", "elementData", elementData);
        setField(vector, "java.util.Vector", "elementCount", 1);
        setField(vector, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", vector);
        
        /* This test fails because method [com.NetChat.server.MyServer.isNickBusy] produces [java.lang.ClassCastException: java.lang.Object cannot be cast to com.NetChat.server.ClientHandler]
            com.NetChat.server.MyServer.isNickBusy(MyServer.java:92) */
        myServer.isNickBusy(null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link NullPointerException} when: o.getName().equals(nick)
     */
    @Test
    @DisplayName("isNickBusy: o.getName().equals(nick) -> ThrowNullPointerException")
    public void testIsNickBusy_ThrowNullPointerException() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        Object[] elementData = new Object[1];
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn(((String) null));
        elementData[0] = ((Object) clientHandlerMock);
        setField(attributeNameEnumeration, "java.util.Vector", "elementData", elementData);
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", 1);
        setField(attributeNameEnumeration, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);
        
        /* This test fails because method [com.NetChat.server.MyServer.isNickBusy] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.isNickBusy(MyServer.java:93) */
        myServer.isNickBusy(null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     * @utbot.invokes {@link Vector#iterator()}
     * @utbot.throwsException {@link NullPointerException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("isNickBusy: for(ClientHandler o: clients) -> ThrowNullPointerException")
    public void testIsNickBusy_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "clients", null);
        
        /* This test fails because method [com.NetChat.server.MyServer.isNickBusy] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.isNickBusy(MyServer.java:92) */
        myServer.isNickBusy(null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link NullPointerException} when: o.getName().equals(nick)
     */
    @Test
    @DisplayName("isNickBusy: o.getName().equals(nick) -> ThrowNullPointerException")
    public void testIsNickBusy_ThrowNullPointerException_2() throws Exception {
        Stack stack = ((Stack) createInstance("java.util.Stack"));
        Object[] elementData = {null};
        setField(stack, "java.util.Vector", "elementData", elementData);
        setField(stack, "java.util.Vector", "elementCount", 1);
        setField(stack, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", stack);
        
        /* This test fails because method [com.NetChat.server.MyServer.isNickBusy] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.isNickBusy(MyServer.java:93) */
        myServer.isNickBusy(null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method isNickBusy(java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     */
    @Test
    @DisplayName("isNickBusy: nick = '' -> return true")
    public void testIsNickBusyReturnsTrueWithEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "server", null);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", 1);
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("");
        vectorSpy.add(clientHandlerMock);

        boolean actual = myServer.isNickBusy("");

        assertTrue(actual);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     */
    @Test
    @DisplayName("isNickBusy: nick = '-^3' (mutated from '-3') -> return false")
    public void testIsNickBusyReturnsFalseWithNonEmptyString() {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("");
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("#$\\\"'");
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("");
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        (when(clientHandlerMock3.getName())).thenReturn("");
        vectorSpy.add(clientHandlerMock3);
        ClientHandler clientHandlerMock4 = mock(ClientHandler.class);
        (when(clientHandlerMock4.getName())).thenReturn("-3");
        vectorSpy.add(clientHandlerMock4);

        boolean actual = myServer.isNickBusy("-^3");

        assertFalse(actual);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     */
    @Test
    @DisplayName("isNickBusy: nick = '10' -> return true")
    public void testIsNickBusyReturnsTrueWithNonEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        setField(myServer, "com.NetChat.server.MyServer", "server", null);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("-3");
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("\n\t\r");
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("XZ");
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        (when(clientHandlerMock3.getName())).thenReturn("10");
        vectorSpy.add(clientHandlerMock3);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MAX_VALUE);

        boolean actual = myServer.isNickBusy("10");

        assertTrue(actual);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#isNickBusy(String)}
     */
    @Test
    @DisplayName("isNickBusy: nick = '' -> return true")
    public void testIsNickBusyReturnsTrueWithEmptyString1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("XZ");
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("");
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock2);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MIN_VALUE);

        boolean actual = myServer.isNickBusy("");

        assertTrue(actual);
    }
    ///endregion

    ///region OTHER: SUCCESSFUL EXECUTIONS for method isNickBusy(java.lang.String)

    @Test
    public void testIsNickBusy1() throws Exception {
        Stack stack = ((Stack) createInstance("java.util.Stack"));
        Object[] elementData = new Object[9];
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        String string = "";
        (when(clientHandlerMock.getName())).thenReturn(string);
        elementData[0] = ((Object) clientHandlerMock);
        setField(stack, "java.util.Vector", "elementData", elementData);
        setField(stack, "java.util.Vector", "elementCount", 1);
        setField(myServer, "com.NetChat.server.MyServer", "clients", stack);

        boolean actual = myServer.isNickBusy(null);

        assertFalse(actual);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method isNickBusy(java.lang.String)

    @Test
    public void testIsNickBusy2() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", -2147483647);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);
        
        /* This test fails because method [com.NetChat.server.MyServer.isNickBusy] produces [java.util.NoSuchElementException]
            java.util.Vector$Itr.next(Vector.java:1174)
            com.NetChat.server.MyServer.isNickBusy(MyServer.java:92) */
        myServer.isNickBusy(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.NetChat.server.MyServer.PMsg

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method PMsg(com.NetChat.server.ClientHandler, java.lang.String, java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     * @utbot.invokes {@link Vector#iterator()}
     */
    @Test
    @DisplayName("PMsg: -> VectorIterator")
    public void testPMsg_VectorIterator() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        setField(attributeNameEnumeration, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);

        myServer.PMsg(null, null, null);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method PMsg(com.NetChat.server.ClientHandler, java.lang.String, java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     * @utbot.invokes {@link Vector#iterator()}
     * @utbot.iterates iterate the loop {@code for(ClientHandler o: clients)} once
     * @utbot.throwsException {@link java.util.NoSuchElementException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("PMsg: for(ClientHandler o: clients) -> ThrowNoSuchElementException")
    public void testPMsg_ThrowNoSuchElementException() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", -256);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);
        
        /* This test fails because method [com.NetChat.server.MyServer.PMsg] produces [java.util.NoSuchElementException]
            java.util.Vector$Itr.next(Vector.java:1174)
            com.NetChat.server.MyServer.PMsg(MyServer.java:105) */
        myServer.PMsg(null, null, null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     * @utbot.invokes {@link Vector#iterator()}
     * @utbot.throwsException {@link NullPointerException} in: for(ClientHandler o: clients)
     */
    @Test
    @DisplayName("PMsg: for(ClientHandler o: clients) -> ThrowNullPointerException")
    public void testPMsg_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "clients", null);
        
        /* This test fails because method [com.NetChat.server.MyServer.PMsg] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.PMsg(MyServer.java:105) */
        myServer.PMsg(null, null, null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method PMsg(com.NetChat.server.ClientHandler, java.lang.String, java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     */
    @Test
    @DisplayName("PMsg: from = mock(), nick = 'from:', msg = 'abc'")
    public void testPMsgWithNonEmptyStrings() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("-3");
        vectorSpy.add(clientHandlerMock);
        ClientHandler fromMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(fromMock))).sendMsg(any());

        myServer.PMsg(fromMock, "from:", "abc");
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     */
    @Test
    @DisplayName("PMsg: from = mock(), nick = '-3', msg = '\n\t\r'")
    public void testPMsgWithNonEmptyStringAndBlankString() {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock3);
        ClientHandler fromMock = mock(ClientHandler.class);
        (when(fromMock.getName())).thenReturn("from:");

        myServer.PMsg(fromMock, "-3", "\n\t\r");
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     */
    @Test
    @DisplayName("PMsg: from = mock(), nick = '-3', msg = ''")
    public void testPMsgWithNonEmptyStringAndEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        setField(myServer, "com.NetChat.server.MyServer", "server", null);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", Integer.MIN_VALUE);
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("abc");
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock2);
        ClientHandler fromMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(fromMock))).sendMsg(any());
        (when(fromMock.getName())).thenReturn("\n\t\r");

        myServer.PMsg(fromMock, "-3", "");
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     */
    @Test
    @DisplayName("PMsg: from = mock(), nick = '', msg = 'abc'")
    public void testPMsgWithEmptyStringAndNonEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", 0);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("XZ");
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("from:");
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("");
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock3);
        ClientHandler clientHandlerMock4 = mock(ClientHandler.class);
        vectorSpy.add(clientHandlerMock4);
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        ClientHandler fromMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(fromMock))).sendMsg(any());
        (when(fromMock.getName())).thenReturn("\n\t\r");

        myServer.PMsg(fromMock, "", "abc");
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     */
    @Test
    @DisplayName("PMsg: from = mock(), nick = '\u00A1' (mutated from ''), msg = 'abc'")
    public void testPMsgWithNonEmptyStrings1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", 0);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("XZ");
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("from:");
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("");
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        (when(clientHandlerMock3.getName())).thenReturn("from:");
        vectorSpy.add(clientHandlerMock3);
        ClientHandler clientHandlerMock4 = mock(ClientHandler.class);
        (when(clientHandlerMock4.getName())).thenReturn("\u043D\u0435\u0442 \u0435\u0433\u043E");
        vectorSpy.add(clientHandlerMock4);
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        ClientHandler fromMock = mock(ClientHandler.class);
        (((ClientHandler) (doNothing()).when(fromMock))).sendMsg(any());

        myServer.PMsg(fromMock, "\u00A1", "abc");
    }
    ///endregion

    ///region FUZZER: ERROR SUITE for method PMsg(com.NetChat.server.ClientHandler, java.lang.String, java.lang.String)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#PMsg(ClientHandler, String, String)}
     */
    @Test
    @DisplayName("PMsg: from = mock(), nick = '\n\t\r', msg = 'ac' -> throw NullPointerException")
    public void testPMsgThrowsNPEWithBlankStringAndNonEmptyString() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn(((String) null));
        vectorSpy.add(clientHandlerMock);
        setField(myServer, "com.NetChat.server.MyServer", "server", null);
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", -1);
        ClientHandler fromMock = mock(ClientHandler.class);
        
        /* This test fails because method [com.NetChat.server.MyServer.PMsg] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.PMsg(MyServer.java:106) */
        myServer.PMsg(fromMock, "\n\t\r", "ac");
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.NetChat.server.MyServer.subscribe

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method subscribe(com.NetChat.server.ClientHandler)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#subscribe(ClientHandler)}
     * @utbot.invokes {@link Vector#add(Object)}
     * @utbot.throwsException {@link NullPointerException} in: clients.add(o);
     */
    @Test
    @DisplayName("subscribe: clients.add(o) : True -> ThrowNullPointerException")
    public void testSubscribe_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "clients", null);
        
        /* This test fails because method [com.NetChat.server.MyServer.subscribe] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.subscribe(MyServer.java:124) */
        myServer.subscribe(null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method subscribe(com.NetChat.server.ClientHandler)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#subscribe(ClientHandler)}
     */
    @Test
    @DisplayName("subscribe: o = mock()")
    public void testSubscribe() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("abc");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler oMock = mock(ClientHandler.class);
        (when(oMock.getName())).thenReturn("abc");
        (((ClientHandler) (doNothing()).when(oMock))).sendMsg(any());

        myServer.subscribe(oMock);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#subscribe(ClientHandler)}
     */
    @Test
    @DisplayName("subscribe: o = mock()")
    public void testSubscribe1() throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("\n\t\r");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("#$\\\"'");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        ClientHandler oMock = mock(ClientHandler.class);
        (when(oMock.getName())).thenReturn("XZ");
        (((ClientHandler) (doNothing()).when(oMock))).sendMsg(any());

        myServer.subscribe(oMock);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#subscribe(ClientHandler)}
     */
    @Test
    @DisplayName("subscribe: o = mock()")
    public void testSubscribe2() throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("XZ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("\n\t\r");
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        (when(clientHandlerMock3.getName())).thenReturn("abc");
        (((ClientHandler) (doNothing()).when(clientHandlerMock3))).sendMsg(any());
        vectorSpy.add(clientHandlerMock3);
        ClientHandler clientHandlerMock4 = mock(ClientHandler.class);
        (when(clientHandlerMock4.getName())).thenReturn("XZ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock4))).sendMsg(any());
        vectorSpy.add(clientHandlerMock4);
        ClientHandler oMock = mock(ClientHandler.class);
        (when(oMock.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(oMock))).sendMsg(any());

        myServer.subscribe(oMock);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method subscribe(com.NetChat.server.ClientHandler)

    @Test
    public void testSubscribe3() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        Object[] elementData = {};
        setField(attributeNameEnumeration, "java.util.Vector", "elementData", elementData);
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", 2147483646);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);

        assertThrows(OutOfMemoryError.class, () -> myServer.subscribe(null));

        Vector myServerClients = ((Vector) getFieldValue(myServer, "com.NetChat.server.MyServer", "clients"));
        int finalMyServerClientsModCount = ((Integer) getFieldValue(myServerClients, "java.util.AbstractList", "modCount"));

        assertEquals(1, finalMyServerClientsModCount);
    }

    @Test
    public void testSubscribe4() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        Object[] elementData = {null, null, null, null};
        setField(attributeNameEnumeration, "java.util.Vector", "elementData", elementData);
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", 4);
        setField(attributeNameEnumeration, "java.util.Vector", "capacityIncrement", -2113929216);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);
        
        /* This test fails because method [com.NetChat.server.MyServer.subscribe] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.broadcastclientslist(MyServer.java:133)
            com.NetChat.server.MyServer.subscribe(MyServer.java:125) */
        myServer.subscribe(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.NetChat.server.MyServer.unsubscribe

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method unsubscribe(com.NetChat.server.ClientHandler)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#unsubscribe(ClientHandler)}
     * @utbot.invokes {@link Vector#remove(Object)}
     * @utbot.throwsException {@link ArrayIndexOutOfBoundsException} in: clients.remove(o);
     */
    @Test
    @DisplayName("unsubscribe: clients.remove(o) : True -> ThrowArrayIndexOutOfBoundsException")
    public void testUnsubscribe_ThrowArrayIndexOutOfBoundsException() throws Exception {
        AttributeNameEnumeration attributeNameEnumeration = ((AttributeNameEnumeration) createInstance("sun.security.x509.AttributeNameEnumeration"));
        Object[] elementData = {};
        setField(attributeNameEnumeration, "java.util.Vector", "elementData", elementData);
        setField(attributeNameEnumeration, "java.util.Vector", "elementCount", 1);
        setField(attributeNameEnumeration, "java.util.AbstractList", "modCount", -255);
        setField(myServer, "com.NetChat.server.MyServer", "clients", attributeNameEnumeration);
        
        /* This test fails because method [com.NetChat.server.MyServer.unsubscribe] produces [java.lang.ArrayIndexOutOfBoundsException: 0]
            java.util.Vector.indexOf(Vector.java:409)
            java.util.Vector.indexOf(Vector.java:387)
            java.util.Vector.removeElement(Vector.java:646)
            java.util.Vector.remove(Vector.java:804)
            com.NetChat.server.MyServer.unsubscribe(MyServer.java:118) */
        myServer.unsubscribe(null);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#unsubscribe(ClientHandler)}
     * @utbot.invokes {@link Vector#remove(Object)}
     * @utbot.throwsException {@link NullPointerException} in: clients.remove(o);
     */
    @Test
    @DisplayName("unsubscribe: clients.remove(o) : True -> ThrowNullPointerException")
    public void testUnsubscribe_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "clients", null);
        
        /* This test fails because method [com.NetChat.server.MyServer.unsubscribe] produces [java.lang.NullPointerException]
            com.NetChat.server.MyServer.unsubscribe(MyServer.java:118) */
        myServer.unsubscribe(null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method unsubscribe(com.NetChat.server.ClientHandler)

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#unsubscribe(ClientHandler)}
     */
    @Test
    @DisplayName("unsubscribe: o = mock()")
    public void testUnsubscribe() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(myServer, "com.NetChat.server.MyServer", "out", null);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("abc");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler oMock = mock(ClientHandler.class);

        myServer.unsubscribe(oMock);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#unsubscribe(ClientHandler)}
     */
    @Test
    @DisplayName("unsubscribe: o = mock()")
    public void testUnsubscribe1() throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("\n\t\r");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("#$\\\"'");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        ClientHandler oMock = mock(ClientHandler.class);

        myServer.unsubscribe(oMock);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#unsubscribe(ClientHandler)}
     */
    @Test
    @DisplayName("unsubscribe: o = mock()")
    public void testUnsubscribe2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("10");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("#$\\\"'");
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);
        setField(myServer, "com.NetChat.server.MyServer", "PORT", -1);
        ClientHandler oMock = mock(ClientHandler.class);

        myServer.unsubscribe(oMock);
    }

    /**
     * @utbot.classUnderTest {@link MyServer}
     * @utbot.methodUnderTest {@link MyServer#unsubscribe(ClientHandler)}
     */
    @Test
    @DisplayName("unsubscribe: o = mock()")
    public void testUnsubscribe3() throws IOException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        ServerSocket serverSocket = new ServerSocket();
        setField(myServer, "com.NetChat.server.MyServer", "server", serverSocket);
        BaseAuthService baseAuthService = new BaseAuthService();
        setField(myServer, "com.NetChat.server.MyServer", "authService", baseAuthService);
        ClientHandler clientHandlerMock = mock(ClientHandler.class);
        (when(clientHandlerMock.getName())).thenReturn("XZ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock))).sendMsg(any());
        vectorSpy.add(clientHandlerMock);
        ClientHandler clientHandlerMock1 = mock(ClientHandler.class);
        (when(clientHandlerMock1.getName())).thenReturn("-3");
        (((ClientHandler) (doNothing()).when(clientHandlerMock1))).sendMsg(any());
        vectorSpy.add(clientHandlerMock1);
        ClientHandler clientHandlerMock2 = mock(ClientHandler.class);
        (when(clientHandlerMock2.getName())).thenReturn("\n\t\r");
        (((ClientHandler) (doNothing()).when(clientHandlerMock2))).sendMsg(any());
        vectorSpy.add(clientHandlerMock2);
        ClientHandler clientHandlerMock3 = mock(ClientHandler.class);
        (when(clientHandlerMock3.getName())).thenReturn("abc");
        (((ClientHandler) (doNothing()).when(clientHandlerMock3))).sendMsg(any());
        vectorSpy.add(clientHandlerMock3);
        ClientHandler clientHandlerMock4 = mock(ClientHandler.class);
        (when(clientHandlerMock4.getName())).thenReturn("XZ");
        (((ClientHandler) (doNothing()).when(clientHandlerMock4))).sendMsg(any());
        vectorSpy.add(clientHandlerMock4);
        ClientHandler oMock = mock(ClientHandler.class);

        myServer.unsubscribe(oMock);
    }
    ///endregion

    ///endregion


    @BeforeEach
    public void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        vectorSpy.clear();
        mockitoCloseable.close();
    }

}
