package baseLIANXi;

/**
 * 
 * 链表：一种常见的数据结果，是一种线性表，但是并不会按线性的顺序存储数据，
 * 而是在每一个节点里存下一个节点的指针。
 * 链表：适合插入 删除，不宜过长，否则会导致便利性能下降。
 * 数组：适合查找遍历，固定长度。
 *
 */
public class LianBiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeManager nm = new NodeManager();
		System.out.println("------------add--------------");
		nm.add(5);
		nm.add(4);
		nm.add(3);
		nm.add(2);
		nm.add(1);
		nm.print();
		System.out.println("------------del--------------");
		nm.del(3);
		nm.print();
		System.out.println("------------find--------------");
		System.out.println(nm.find(1));
		System.out.println("------------update--------------");
		nm.update(1, 10);
		nm.print();
		System.out.println("------------insert--------------");
		nm.insert(3, 20);
		nm.print();
	}

}

class NodeManager{
	private Node root; //根节点
	private int currentIndex = 0; //当前节点的序号，每次操作从0开始
	public void add(int data) {
		if(root == null) {
			root = new Node(data);
		}else {
			root.addNode(data);
		}
	}
	public void del(int data) {
		if(root == null)return;
		if(root.getData() == data) {
			root = root.next;
		}else {
			root.delNode(data);
		}
	}
	public void print() {
		if(root != null) {
			System.out.print(root.getData()+"-->");
			root.printNode();
			System.out.println();
		}
	}
	public boolean find(int data) {
		if(root == null)return false;
		if(root.getData() == data) {
			return true;
		}else {
			return root.findNode(data);
		}
	}
	public boolean update(int oldData,int newData) {
		if(root == null)return false;
		if(root.getData() == oldData) {
			root.setData(newData);
			return true;
		}else {
			return root.updataNode(oldData, newData);
		}
	}
	//向索引前插	
	public void insert(int index,int data) {
		if(index<0)return;
		currentIndex = 0;
		if(index==currentIndex) {
			Node newNode = new Node(data);
//			root.next = new Node(data);  //后插
			newNode.next = root;  //前插
			root = newNode;
		}else {
			root.insertNode(index,data);
		}
	}
	
	private class Node{
		private int data;
		private Node next;//把当前类型作为属性（Java可以这么用）
		public Node(int data) {
			this.data = data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public int getData() {
			return data;
		}
		//添加节点
		public void addNode(int data) {
			if(this.next==null) {
				this.next = new Node(data);
			}else {
				this.next.addNode(data);
			}
		}
		//删除节点
		public void delNode(int data) {
			if(this.next != null) {
				if(this.next.data == data) {
					this.next = this.next.next;
				}else {
					this.next.delNode(data);;
				}
			}
		}
		//输出所有节点
		public void printNode() {
			if(this.next != null) {
				System.out.print(this.next.data+"-->");
				this.next.printNode();
			}
		}
		//查找一个
		public boolean findNode(int data) {
			if(this.next != null) {
				if(this.next.data == data) {
					return true;
				}else {
					return this.next.findNode(data);
				}
			}
			return false;
		}
		//修改节点
		public boolean updataNode(int oldData,int newData) {
			if(this.next != null) {
				if(this.next.data == oldData) {
					this.next.data = newData;
					return true;
				}else {
					return this.next.updataNode(oldData, newData);
				}
			}
			return false;
		}
		//插入节点
		public void insertNode(int index,int data) {
			currentIndex++;
			if(index == currentIndex) {
				Node  newNode = new Node(data);
				newNode.next = this.next;
				this.next = newNode;
			}else {
				this.next.insertNode(index, data);
			}
		}
	}
}