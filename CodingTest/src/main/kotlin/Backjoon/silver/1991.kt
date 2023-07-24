import java.util.*
import java.io.*

data class TreeNode<T>(
    var data: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

class Tree{
    var root: TreeNode<String>? = null

    fun add(data: String, left: String, right: String){
        if(root == null){
            if(data != ".") root = TreeNode(data)
            if(left != ".") root!!.left = TreeNode(left)
            if(right != ".") root!!.right = TreeNode(right)
        }
        else search(root!!, data, left, right)
    }

    fun search(root: TreeNode<String>, data: String, left: String, right: String){
        if(root.data == data){
            if(left != ".") root.left = TreeNode(left)
            if(right != ".") root.right = TreeNode(right)
        }

        else{
            if(root.left != null) search(root.left!!,data,left,right)
            if(root.right != null) search(root.right!!,data,left,right)
        }
    }

    // 전위 순회 (루트, 왼쪽 자식, 오른쪽 자식)
    fun preOrder(root: TreeNode<String>){
        print(root.data)
        if(root.left != null) preOrder(root.left!!)
        if(root.right != null) preOrder(root.right!!)
    }

    // 중위 순회 (왼쪽 자식, 루트, 오른쪽 자식)
    fun inOrder(root: TreeNode<String>){
        if(root.left != null) inOrder(root.left!!)
        print(root.data)
        if(root.right != null) inOrder(root.right!!)
    }

    // 후위 순회 (왼쪽 자식, 오른쪽 자식, 루트)
    fun postOrder(root: TreeNode<String>){
        if(root.left != null) postOrder(root.left!!)
        if(root.right != null) postOrder(root.right!!)
        print(root.data)
    }
}

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tree = Tree()

    val count = br.readLine().toInt()

    repeat(count){
        val (a, b, c) = br.readLine().split(" ").map { it.toString() }
        tree.add(a, b, c)
    }

    tree.preOrder(tree.root!!)
    println()
    tree.inOrder(tree.root!!)
    println()
    tree.postOrder(tree.root!!)
}