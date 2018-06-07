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
public class RegularEngine {
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
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("gas", 35);
                                             ecor.bsupply.BatterySupply.sharedSupply().provide("traction", 400);
                                             ecor.CalibratorStack.pop();
                                             ; }
    public RegularEngine() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528390971072L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "26OfP/HZhtOTt8U19A9zcGco8A0AAA==");
}
