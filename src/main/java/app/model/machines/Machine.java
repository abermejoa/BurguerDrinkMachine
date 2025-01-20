package app.model.machines;

public class Machine {

    private Machine(){
        System.out.println("Se ha iniciado la máquina");
    }

    private static class Impl{
        private static final Machine INSTANCE = new Machine();
    }

    public Machine getInstance(){
        return Impl.INSTANCE;
    }
}
