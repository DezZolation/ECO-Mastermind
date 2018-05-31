import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                                                     System.
                                                       out.
                                                       println(
                                                         "x: " +
                                                         x[0]);
                                                 }
                                             }
                                             ecor.CalibratorStack.pop();
                                             ;
                                             final int[] y = new int[1];
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
                                               y[0])/(100);
                                             System.out.println(supplyRatio + " " + demandRatio);
                                             if (supplyRatio > demandRatio * 1.1 && mode < $UTILMODES.$MAX) ++mode;
                                             else if (demandRatio > supplyRatio * 1.1 && mode > 0) --mode;
                                             }
                                             });
                                             {
                                                 for (ecor.CalibratorStack.calibrate(y[0] =
                                                        0);
                                                      y[0] <
                                                        200;
                                                      ecor.CalibratorStack.calibrate(y[0] +=
                                                        1)) {
                                                     System.
                                                       out.
                                                       println(
                                                         "y: " +
                                                         y[0]);
                                                 }
                                             }
                                             ecor.CalibratorStack.pop();
                                             ;
                                             try {
                                                 Socket s =
                                                   new Socket(
                                                   "127.0.0.1",
                                                   9042);
                                                 BufferedReader input =
                                                   new BufferedReader(
                                                   new InputStreamReader(
                                                     s.
                                                       getInputStream(
                                                         )));
                                                 String answer =
                                                   input.
                                                   readLine(
                                                     );
                                                 System.
                                                   out.
                                                   println(
                                                     "The answer is: " +
                                                     answer);
                                             }
                                             catch (IOException v) {
                                                 System.
                                                   out.
                                                   println(
                                                     v);
                                             }
    }
    public Test() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1527763923096L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "t9nt8w+k7sSu1A0AAA==");
}
