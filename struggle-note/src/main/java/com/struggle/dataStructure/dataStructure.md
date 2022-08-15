# 数据结构
数据结构是一种具有一定逻辑关系，在计算机中应用某种存储结构，并且封装了相应操作的数据元素集合。

## 线性表
### 1.数组
数组由相同类型的元素组成，并且是使用一块连续的内存来存储。
我们利用元素的索引可以计算出该元素对应的存储地址。
**提供随机访问 并且容量有限。**

### 2.链表
链表是一种线性表，但是并不会按线性的顺序存储数据，使用的不是连续的内存空间来存储数据。
但链表相比于数组会占用更多的空间。
使用链表结构可以克服数组需要预先知道数据大小的缺点。

#### 分类
* 单链表：单链表只有一个方向，尾结点通常指向 null。
* 双向链表：包含两个指针，一个 prev 指向前一个节点，一个 next 指向后一个节点。
* 循环链表：一种特殊的单链表，尾结点指向链表的头结点。
* 双向循环链表：最后一个节点的 next 指向 head，而 head 的 prev 指向最后一个节点，构成一个环。

### 3.栈
栈 (stack)只允许在有序的线性数据集合的一端（称为栈顶 top）进行加入数据（push）和移除数据（pop）。
按照**后进先出**运作。

_栈常用一维数组或链表来实现，用数组实现的栈叫作**顺序栈** ，用链表实现的栈叫作**链式栈** 。_

### 4.队列
队列是先进先出的线性表。队列只允许在后端进行插入操作也就是入队，在前端进行删除操作也就是出队。

_常用链表或者数组来实现，用数组实现的队列叫作**顺序队列** ，用链表实现的队列叫作**链式队列**_
#### 分类
* 单队列：每次添加元素时，都是添加到队尾。
  * 顺序队列：数组实现的队列
  * 链式队列：链表实现的队列
* 循环队列：结尾指针指向下标为0的位置。
## 哈希表

## 树
树是由n（n≥0）个结点构成的有限集合。当n=0时，称该树为空树。

特点：
* 一棵树中的任意两个结点有且仅有唯一的一条路径连通。
* 一棵树如果有 n 个结点，那么它一定恰好有 n-1 条边。
* 一棵树不包含回路。
### 二叉树
二叉树是每个结点最多只有俩颗不相交的树构成的结构。

![](./img/树.png)

层次：从根开始定义起，根为第1层，根的子节点为第2层，以此类推；
树的高度 ：根节点的高度。
节点的深度 ：根节点到该节点的路径所包含的边数

#### 满二叉树
一个二叉树每一层的结点数都达到最大值，则称这个二叉树为满二叉树。

![](./img/满二叉树.png)

#### 完全二叉树
一个二叉树除最后一层其余层都是满的，则称这个二叉树为完全二叉树。

![](./img/完全二叉树.png)

#### 平衡二叉树
它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

![](./img/平衡二叉树.png)

### 红黑树
红黑树是为了在进行插入和删除操作时通过特定操作保持二叉查找树的平衡，从而获得较高的查找性能。
![](./img/红黑树.png)
特点：
1. 每个节点非红即黑；
2. 根节点总是黑色的；
3. 每个叶子节点都是黑色的空节点（NIL节点）；
4. 如果节点是红色的，则它的子节点必须是黑色的（反之不一定）；
5. 从根节点到叶节点或空子节点的每条路径，必须包含相同数目的黑色节点（即相同的黑色高度）。

红黑树通过左旋转和右旋转和变色来保证上面的特点始终成立。
## 图