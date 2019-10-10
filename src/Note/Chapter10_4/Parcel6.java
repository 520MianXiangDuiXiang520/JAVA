package Note.Chapter10_4;
import static junbao.tool.Print.*;

public class Parcel6 {
    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip {
                private int id;
                TrackingSlip(int id){
                    this.id = id;
                }

                int getId(){
                    return id;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip(1);
            int s = trackingSlip.getId();
            coutln(s);
        }
    }

    public void track(boolean b){
        internalTracking(b);
    }

    public static void main(String[] args) {
        Parcel6 p6 = new Parcel6();
        p6.track(true);
    }
}
