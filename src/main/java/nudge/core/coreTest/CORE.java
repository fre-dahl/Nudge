package nudge.core.coreTest;

import nudge.core.input.GamePad;
import nudge.core.input.Keyboard;
import nudge.core.input.Mouse;
import org.lwjgl.Version;

import java.util.Objects;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * @author Frederik Dahl
 * 17/08/2021
 */


public final class CORE {
    
    public static final long MAIN_THREAD_ID = Thread.currentThread().getId();
    
    private static CORE instance;
    
    // Access any statically through get()
    public Window window;
    public Application app;
    public Mouse mouse;
    public Keyboard keyboard;
    public GamePad controller;
    
    private float dt;
    private float fps;
    
    
    private CORE() { }
    
    
    public void run(final Application application) {
        
        try {
            initialize(application);
            coreLoop();
        }
        finally {
            terminate();
        }
        
    }
    
    private void initialize(Application application) {
        
        if (application == null) throw new IllegalStateException(); // just suppressing IDEA "warnings"
        
        printSystemInfo();
        
        app = application;
        mouse = new Mouse();
        keyboard = new Keyboard();
        window = new NudgeWindow();
        
        window.initialize(application.config());
        app.initialize();
        
    
    }
    
    private void coreLoop() {
        
        window.makeContextCurrent();
        window.createCapabilities();
    
        float beginTime = (float) glfwGetTime();
        float endTime;
        fps = 0.0f;
        dt = 0.0f;
        
        glEnable(GL_BLEND);
        glBlendFunc(GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
        glClearColor(0.3f, 0.5f, 0.7f, 0.0f);
        
        while (!window.shouldClose()) {
            
            mouse.step();
            keyboard.step();
            
            if (!window.isMinimized()) {
                app.queryInput();
                app.update(dt);
                app.render();
            }
            
            window.swapBuffers();
            window.pollInputEvents();
            
            endTime = (float) glfwGetTime();
            dt = endTime - beginTime;
            beginTime = endTime;
            fps = 1/dt;
        }
    
    }
    
    private void terminate() {
        app.exit();
        window.close();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();
    }
    
    private void printSystemInfo() {
        
        String platform = System.getProperty("os.name") + ", " + System.getProperty("os.arch") + " Platform.";
        int numProcessors = Runtime.getRuntime().availableProcessors();
        int JREMemoryMb = (int)(Runtime.getRuntime().maxMemory() / 1000000L);
        String jre = System.getProperty("java.version");
        
        System.out.println("\nWelcome!\n");
        System.out.println("SYSTEM INFO\n");
        
        System.out.println("---Running on: " + platform);
        System.out.println("---jre: " + jre);
        System.out.println("---Available processors: " + numProcessors);
        System.out.println("---Reserved memory: " + JREMemoryMb + " Mb");
        
        System.out.println("---LWJGL version: " + Version.getVersion());
        System.out.println("---GLFW version: " + glfwGetVersionString());
        
    }
    
    public static void EXIT() { instance.window.signalToClose(); }
    
    public static CORE get() { return instance == null ? instance = new CORE() : instance; }
    
    public static boolean isMainThread(long threadID) {return threadID == CORE.MAIN_THREAD_ID;}
    
    public static float deltaTime() { return instance.dt; }
    
    public static float fps() { return instance.fps; }
    
}
