import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
class $UTILMODES{
    public static final int $MAX = 2;
    public static final int high = 2;
    public static final int low = 1;
    public static final int mid = 0;
}
public class Test {
    public static void main(String[] args) { final int[] x = new int[1];
                                             ecor.CalibratorStack.push(new ecor.Calibrator() {
                                             double supplyRatio = 0;
                                             public int mode = $UTILMODES.$MAX;
                                             public int getMode(int max) {
                                             return mode;
                                             }
                                             public int supply() {
                                             return ecor.bsupply.BatterySupply.sharedSupply().getRemainingCapacity();}
                                             private double supplyLimit = (ecor.bsupply.BatterySupply.sharedSupply().getRemainingCapacity()) *
                                               0.6;
                                             private int initialSupply = this.supply();
                                             public Object calibrate(Object input) {
                                             supplyRatio = (supplyLimit - (initialSupply - this.supply()))/supplyLimit;
                                             return input;
                                             }
                                             public void adjust() {
                                             double demandRatio = (double)(100 -
                                               x[0])/(100);
                                             System.out.println(supplyRatio + " " + demandRatio);
                                             if (supplyRatio > demandRatio * 1.1 && mode < $UTILMODES.$MAX) ++mode;
                                             else if (demandRatio > supplyRatio * 1.1 && mode > 0) --mode;
                                             }
                                             });
                                             {
                                                 for (ecor.CalibratorStack.calibrate(x[0] =
                                                        0);
                                                      x[0] <
                                                        100;
                                                      ecor.CalibratorStack.calibrate(x[0] +=
                                                        1)) {
                                                     
                                                 }
                                             }
                                             ecor.CalibratorStack.pop();
                                             ;
                                             provide(
                                               "water",
                                               40);
    }
    public static void provide(String resource, int amount) {
        
    }
    public Test() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528033006979L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "8BfPfL72zPgdNlD/BS0yKcCnDgAA");
}
