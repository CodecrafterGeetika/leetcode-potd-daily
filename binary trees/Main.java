class Main {
    static class Node {
        int val;
        Node left;
        Node right;
        public Node (int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root) {
        if(root==null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int count(Node root) {
        if(root==null) return 0;
        int lh = count(root.left);
        int rh = count(root.right);
        return lh+rh+1;

    }
        public static int sum(Node root) {
        if(root==null) return 0;
        int lh = sum(root.left);
        int rh = sum(root.right);
        return lh+rh+root.val;

    }
    public static int diameter2(Node root) {//T.C =O(n^2)
        if(root==null) return 0;
        int leftDia = diameter2(root.left);
        int lh = height(root.left);
        int rightDia = diameter2(root.right);
        int rh = height(root.right);
        int selfDia = lh + rh+1;
        return Math.max(selfDia, Math.max(leftDia,rightDia));
        
    }
    static class Info {
        int diam;
        int ht;
        public Info(int diam,int ht) {
            this.diam = diam;
            this.ht=ht;
            
        }
    }
    public static Info diameter(Node root){//O(n)
        if(root == null) return new Info(0,0);
       Info leftInfo = diameter(root.left);
       Info rightInfo = diameter(root.right);
       int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
       int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
       return new Info(diam,ht);
    }
    public static boolean isSubtree(Node root, Node subroot) {
        if(root == null) return false;
        if(root.val == subroot.val) {
            if(isIdentical(root,subroot)) {
                return true;
            }
        }
        return isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
        
    }
    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
        }else if(node == null || subRoot == null || node.val != subRoot.val) {
            return false;
        }
        if(!isIdentical(node.left,subRoot.left)) return false;
    if(!isIdentical(node.right,subRoot.right)) return false;
     return true;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right= new Node(5);
        System.out.println(isSubtree(root,subroot));
    }
}
