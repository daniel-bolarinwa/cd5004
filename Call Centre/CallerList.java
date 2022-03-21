// /** Class used to record the details of a tenant
//  *  @author Daniel Bolarinwa
//  */

// import java.util.ArrayList;

// public class CallerList {
//     private ArrayList<Caller> callerList;
        
//     public CallerList() {
//         callerList = new ArrayList<>();
//     }
	
//     public void addCaller(Caller callerIn) {
//         callerList.add(callerIn);
//     }
        
//     public void removeCaller(int callerIdIn) {
//         Caller caller = search(callerIdIn);
//         if (caller != null) {
//             callerList.remove(caller);
//         }
//     }       
       
//     public Caller search(int callerIdIn) {
//         for (Caller currentCaller: callerList) {  
//             if (currentCaller.getCallerId() == callerIdIn) {
//                 return currentCaller;
//             }
//         }
//         return null;
//     }
        
//     public Caller getCaller(int positionIn) {
//         if (positionIn < 1 || positionIn > getCallerCount()) {
//             return null;
//         }
//         else {
//             return callerList.get(positionIn -1);
//         }
//     }
 
//     public boolean isEmpty() {
//         return callerList.isEmpty();
//     }
        
//     public int getCallerCount() {       
//         return callerList.size();
//     }
        
//     @Override
//     public String toString()
//     {
//         return callerList.toString();
//     }
// }