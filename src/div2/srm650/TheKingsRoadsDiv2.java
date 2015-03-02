package div2.srm650;

import java.util.ArrayList;
import java.util.List;

public class TheKingsRoadsDiv2 {

	public String getAnswer(int h, int[] a, int[] b){
		int treeSize = (1 << h) -1;
		for(int i = 0; i < a.length; i++){
			Vertex[] vertices = new Vertex[treeSize];
			for(int j = 0; j < treeSize; j++){
				vertices[j] = new Vertex();
			}
			for(int j = 0; j < a.length;j++){
				if(j != i && a[j] != b[j]){
					Vertex u = vertices[a[j]-1];
					Vertex v = vertices[b[j]-1];
					u.adj.add(v);
					v.adj.add(u);
				}
			}
			
			for(Vertex root : vertices){
				if(root.adj.size() == 2){
					if(root.dfs(h)){
						return "Correct";
					}
					break;
				}
			}
		}
		return"Incorrect";
	}

}

class Vertex{
	List<Vertex> adj = new ArrayList<Vertex>();
	int subtreeSize;
	Vertex parent;
	
	public boolean dfs(int h){
		if(h <= 0) return false;
		subtreeSize = 1;
		for(Vertex v : adj){
			if(v != parent){
				if(v.parent != null){
					return false;
				}
				v.parent = this;
				if(!v.dfs(h-1)){
					return false;
				}
				subtreeSize += v.subtreeSize;
			}
		}
		return subtreeSize == (1 << h) -1;
	}
}

