package amazoninterview

class Q3 {
}

/*
We want to be able to determine the top-100 most frequently deployed software packages across
the Amazon Web Services environments. Assume that our software deployment system will invoke a
method providing the software package name whenever it deploys a software package.

Given the example method signatures below as a starting point and using any language you are
comfortable using, provide an implementation for the two methods.

Example Method Signatures:

void recordDeployment(String softwarePackageName);

List<String> getTop100Deployments();

Example Deployment Inputs:

Package1 -> recordDeployment("Package1")
Package2 -> recordDeployment("Package2")
Package3 -> recordDeployment("Package3")
Package1 -> recordDeployment("Package1")
Package3 -> recordDeployment("Package3")
Package3 -> recordDeployment("Package3")
....

Example Expected Output:

getTop100Deployments()
[Package3, Package1, Package2]

recordDeployment("Package1")
recordDeployment("Package1")
recordDeployment("Package1")
recordDeployment("Package1")

[Package1, Package3, Package2]
*/

// determine the correct DS and algorithm 
// i will need to store the frequency somehow
// ds needs to be update when the deployment occurs 
// Priority is the focus for this case 
// method to record the deployment 
//

//@NoArgsConstructor
//@Data
//class Key {
//  String name;
//  Key next, prev;
//  Frequency parent;
//}
//
//@NoArgsConstructor
//@Data
//class Frequency {
//  int count;
//  Key start, end;
//  Frequency parent;
//
//  public Frequency(int )
//}
//
//class MostFrequentDeployedPackageCache {
//  Map<String, Key> map = new HashMap<>()
//  int size = 0, capacity = 0;
//  Frequency start, end;
//
//  public MostFrequentDeployedPackageCache(int capacity) {
//    this.capacity = capacity;
//    start = new Frequency()
//  }
//
//  public void recordDeployment(String name) {
//    Key key = null;
//    if (this.map.contains(name)) {
//      key = this.map.get(name);
//    } else if (size < capacity) {
//      key = new Key(name, start);
//    }
//  }
//
//  public List<String> getTop100Deployments() {}
//}
