package ChainOfResponsibilityDemo.demo_2.middleware;

// Basic middleware class
public abstract class Middleware {
    private Middleware next;

    // Builds chain of middleware object
    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head=first;
        for(Middleware nextInChain: chain) {
            head.next=nextInChain;
            head=nextInChain;
        }
        return first;
    } 
    // Subclasses will implement this method with concrete checks.
    public abstract boolean check(String email, String password);

    // Run checks on the next object on chain 
    // or ends traversing if we're in last object in chain
    protected boolean checkNext(String email, String password) {
        if(next==null) {
            return true;
        }
        return next.check(email, password);
    }
}
