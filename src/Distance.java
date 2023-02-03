
public class Distance {
	
	//count number of nodes
	static int count = 1;
	
	public static float findDistance(StoreNode nodes[],int n,int c,String[] differentPath, int path) {
		
		float localshortestDistance = 999999999;
		int nextNode = 0;
		
		for(int i = 0; i < n; i++) {
			
			//check whether the first node has been visited
			if(nodes[i].getpassed() == false) {
				
													//x2				x1				    x2   				x1				 y2			         y1				     y2				   y1
				float distance =(float) Math.sqrt((nodes[i].getx() - nodes[c].getx()) * (nodes[i].getx() - nodes[c].getx())  + (nodes[i].gety() - nodes[c].gety()) * (nodes[i].gety() - nodes[c].gety()));
				
				
				//finding next node with shortest distance
				if( distance < localshortestDistance) {
					localshortestDistance = distance;
					nextNode = i;
			}
		}
	}
		//setting next node as visited
		nodes[nextNode].setpassed(true);
		
		//adding the next node to the path description
		differentPath[path] = differentPath[path] + " - " + Integer.toString(nextNode+1);
		
		//increment count of node
		count++;
		
		
		//base case to stop after all nodes
		if(count > n - 1) {
			count= 1;
			return localshortestDistance;
		}
		else {
			//recursive call to start with another node
			return localshortestDistance + findDistance(nodes,n,c,differentPath,path);
		}
		
}
}	
	
	