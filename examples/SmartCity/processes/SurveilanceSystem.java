class $UTILMODES{
    public static final int $MAX = 2;
    public static final int high = 2;
    public static final int low = 1;
    public static final int mid = 0;
}
public class SurveilanceSystem {
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
                                             //System.out.println(supplyRatio + " " + demandRatio);
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
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("bandwidth", 40);
                                             ecor.bsupply.BatterySupply.sharedSupply().provide("footage", 100);
                                             ; }
    public SurveilanceSystem() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528963213232L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "u0c/f/Kzdacnb/Or6B9y/UUDAA4AAA==");
}
