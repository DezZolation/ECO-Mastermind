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
public class Computer {
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
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("power", 40);
                                             ecor.bsupply.BatterySupply.sharedSupply().provide("bandwidth", 60);
                                             ; }
    public Computer() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528390919204L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "euK2uIH+AeqnJm/cDQAA");
}
