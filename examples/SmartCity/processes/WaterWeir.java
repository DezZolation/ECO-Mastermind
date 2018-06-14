class $UTILMODES{
    public static final int $MAX = 2;
    public static final int high = 2;
    public static final int low = 1;
    public static final int mid = 0;
}
public class WaterWeir {
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
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("power", 30);
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("bandwidth", 30);
                                             ecor.bsupply.BatterySupply.sharedSupply().provide("water", 50 );
                                             ; }
    public WaterWeir() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528963170971L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "47fFFfQPDKJAjOANAAA=");
}
