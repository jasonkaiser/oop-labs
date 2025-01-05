package org.example;

public class Adapter {

    public static void main(String[] args) {
        OldDeviceImp test = new OldDeviceImp();
        test.operateOldFunction();

        NewDeviceImp test2 = new NewDeviceImp();
        test2.operateNewFunction();

        DeviceAdapter deviceAdapter = new DeviceAdapter(test);
        deviceAdapter.operateNewFunction();

    }

}

interface OldDevice{

    public void operateOldFunction();
}

interface NewDevice{

    public default void operateNewFunction(){
        System.out.println("New Function");
    };
}

class OldDeviceImp implements OldDevice{

    @Override
    public void operateOldFunction(){
        System.out.println("Old Function");
    }

}

class NewDeviceImp implements NewDevice{

}

class DeviceAdapter implements NewDevice{

    private OldDeviceImp oldDeviceImp;

    public DeviceAdapter(OldDeviceImp oldDeviceImp){

        this.oldDeviceImp = oldDeviceImp;
    }

}