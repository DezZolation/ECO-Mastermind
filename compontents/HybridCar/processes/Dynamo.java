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
public class Dynamo {
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
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("traction", 10);
                                             ecor.bsupply.BatterySupply.sharedSupply().provide("power", 8);
                                             ; }
    public Dynamo() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528390954551L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "ZuKOuH/+AayT/wDUDQAA");
}
