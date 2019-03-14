package jit;

/**
 * @author huanghaoxing
 */
public class Switch {




    public static void main(String[] args) {
        long sum=0;
        ChannelState[] values = ChannelState.values();
        for(int i=0;i<10000000;i++){
            sum += test(values[i%5]);
        }
        System.out.println(sum);
    }


    public static int test(ChannelState state){
        int i=0;
        switch (state) {
            case CONNECTED:
                i+=10;
                break;
            case DISCONNECTED:
                i+=20;

                break;
            case SENT:
                i+=30;
                break;
            case RECEIVED:
                i+=40;

                break;
            case CAUGHT:
                i+=60;

                break;
            default:
                i+=90;

        }
        return i;

    }


}
