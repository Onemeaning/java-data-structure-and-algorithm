# 															数据结构与算法

## 几个经典的算法题

* #### 字符串匹配（KMP）

* #### 汉诺塔小游戏（分治算法）

* #### 八皇后问题（回溯算法）

* #### 马踏棋盘问题（DFS + 贪心算法）

* #### 约瑟夫（丢手帕）问题（单项循环列表）

* #### 五子棋程序（二维数组 稀疏数组）

* #### 修路问题（最小生成树普利姆算法）

* #### 最短路径算法（弗洛伊德算法）

========================================================================
## 1、稀疏数组

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/sparearray.png" 
height = "400"  alt = "稀疏数组"/></div> <br/><br/>


## 2、队列Queue的相关问题

~~~ java
1) 两个指针: front (栈前指针) rear (栈尾指针)
2) 数组模拟栈注意数组的循环使用(取模运算)
3) rear == front判断栈是否为空?
4) ( rear + maxSize - front )% maxSize得到栈中数据的个数
~~~

### 3、单向列表

### 4、双向列表

### 5、单向循环列表（丢手帕问题）

**Josephu问题为:**设编号为1, 2, .n的n个人围坐一圈， 约定编号为k (1<=k<=n) 的人从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生-一个出队编号的序列。n=5,即有5个人；k=1,从第一一个人开始报数；m=2,数2下；

答案：2->4->1->5->3

### 6、栈

* **求解表达式的值**
* **逆波兰表达式**

```text
例如: (3+4)X5-6对应的后缀表达式就是34+5 x 6-,针对后缀表达式求值步骤如下:
队左至右扫描，将3和4压入堆栈;
遇到+运算符，因此弹出4和3 (4为根顶元素，3为次顶元素)，计算出3+4的值，得7，再将7入栈;
将5入栈:
接下来是X运算符，因此弹出5和7.计算出7X5=35.将35入栈:
将6入栈:
最后是-运算符，计算出35-6的值。即29.由此得出最终结果
```

* **中缀表达式转换为后缀表达式**（面试重点）

```text
具体步骤如下:
1、初始化两个栈:运算符栈s1和储存中间结果的栈s2;
2、从左至右扫描中缀表达式;
3、遇到操作数时，将其压s2;
4、遇到运算符时，比较其与s1栈项运算符的优先级:
  4-1）如果sl为空，或栈项运算符为左括号“(" ，则直接将此运算符入栈; 
  4-2）否则，若优先级比栈顶运算符的高，也将运算符压入sl;
  4-3）否则，将s1 栈项的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较;
5、遇到括号时:
  5-1)如果是左括号“("，则直接压入s1
  5-2)如果是右括号“)”。则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
6、重复步骤2至5.直到表达式的最右边
7、将s1中剩余的运算符依次弹出并压入s2
8、依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
```

### 6、递归（Recursion）


<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/recursion.png" 
height = "400"  alt = "递归"/>

#### **6.1对迷宫问题的讨论**

~~~
1)小球得到的路径，和程序员设置的找路策略有关即:找路的上下左右的顺序相关
2)再得到小球路径时， 可以先使用(下右上左)， 再改成(上右下左), 看看路径是不是有变化
3)测试回溯现象
4)思考: 如何求出最短路径?思路-》 代码实现.
~~~



#### 6.2八皇后问题介绍

~~~
八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯.贝瑟尔于
1848年提出:在8X8格的国际象棋上摆放八个皇后，使其不能互相攻击，即:任意两个皇后都不能处于同-行、
同- -列或同- -斜线上，间有多少种摆法(92)。
~~~



**八皇后问题算法思路分析**

~~~
1)第一个皇后先放第一行第一列
2)第二个皇后放在第二行第一列、然后判断是否0K，如果不OK， 继续放在第二列、第三列、依次把所有列都放完，找到一个合适。
3)继续第三个皇后，还是第一列、第二....直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
4) 当得到一个正确解时，在栈回退到上-一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
5)然后回头继续第一个皇后放第二列，后面继续循环执行1,2,3,4的步骤。
~~~







## 7、排序算法

### 7.1冒泡排序的及其优化版本 O(n^2)

**冒泡排序(Bubble Sorting) 的基本思想是:**

~~~
   通过对待排序序列从前向后(从下标较小的元素开始) ,依次比较相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。

   因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下来没有进行过交换，就说明序列有序，因此要在排序过程中设置一个标志flag判断元素是否进行过交换。从而减少不必要的比较。
~~~



### 7.2选择排序 O(n^2)

**选择排序思想:**

~~~
   选择排序(select sorting)也是一种简单的排序方法。它的基本思想是:第一从arr[0]^ arr[n-1]中选取最小值，与arr[0]交换， 第二决从arr[1] arr[n-1]中选取最小值，与arr[1]交换， 第三次从arr[2] arr[n-1]中选取最小值，与arr[2]交换， ..第i次从arr[i-1]^ arr[n-1]中选取最小值，与arr[i-1]交换，..第n-1次从arr[n-2]^ arr[n-1]中选取最小值，与arr[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
~~~

### 7.3插入排序 O(n^2)

**插入排序法思想:**

~~~
  插入排序(Insertion Sorting)的基本思想是:把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
~~~



### 7.4希尔排序 O(n log^2 n)

**希尔排序法介绍**

~~~
   希尔排序是希尔(DonaldShell)于1959年提出的一种排序算法。希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
~~~

**希尔排序法基本思想**

~~~
   希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序:随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
~~~

### 7.5快速排序 O(n^2)

**快速排序法介绍:**

~~~
   快速排序(Quicksort) 是对冒泡排序的一种改进。基本思想是:通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
~~~

### 7.6归并排序 O(n log n)

**归并排序介绍:**

~~~
   归并排序(MERGE- SORT)是利用归并的思想实现的排序方法，该算法采用经典的分治(divide- and-conquer)策略(分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案修补"在一
起，即分而治之)。

~~~

### 7.7基数排序 O(n * k)

**基数排序(桶排序)介绍:**

~~~
1)基数排序(radixsort)属于“分配式排序”(distributionsort) ，又称“桶子法”(bucket sort)或binsort, 顾名思义，它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
2)基数排序法是属于稳定性的排序，基数排序法的是效率高的稳定性排序法
3)基数排序(RadixSort)是桶排序的扩展
4)基数排序是1887年赫尔曼何乐礼发明的。它是这样实现的:将整数按位数切割成不同的数字，然后按每个位数分别比较。
~~~


<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/radixSort.png" 
height = "400"  alt = "桶排序"/></div> <br/><br/>


## 8、查找算法

### 8.1 线性查找

### 8.2 二分查找

**二分查找的思路分析**

~~~
1.首先确定该数组的中间的下标 mid= (left+right)/2
2.然后让需要查找的数findVal和arr[mid]比较
2.1 findVal > ar[mid],说明你要查找的数在mid的右边,因此需要递归的向右查找
2.2 findVal < ar[(mid],说明你要查找的数在mid的左边，因此需要递归的向左查找
2.3 findVal == arr[mid]说明找到，就返回
//什么时候我们需要结束递归
1)找到就结束递归
2)递归完整个数组，仍然没有找到indVal ,也需要结束递归当left> right就需要退出

~~~

### 8.3 插值查找

​    适用于等差数列的情况，核心是改变了二分查找中的求 mid= (left+right)/2 的算法；

​    是一种自适应mid的算法；

~~~
//求出mid
int mid = left + (right - 1eft) * (findVal - arr[left]) / (arr[right] - arr[1eft]);
~~~



### 8.4 斐波那契查找 (黄金分割查找)

**斐波那契(黄金分割法)查找基本介绍:**

~~~
1)黄金分割点是指把一条线段分割为两部分，使其中一部分与全长之比等于另一部分与这部分之比。取其前三位数字的近似值是0.618。由于按此比例设计的造型十分美丽，因此称为黄金分割，也称为虫外比。这是一个神奇的数字，会带来意向不大
的效果。
2)斐波那契数列{1.1.2,3,5,8, 13,21, 34, 55}发现斐波那契数列的两个相邻数的比例，无限接近黄金分割值0.618
~~~


<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/fibnacciSearch.png" 
height = "400"  alt = "斐波那契查找"/></div> <br/><br/>
 

## 9、树

#### **9.1.1为什么需要树这种数据结构**

~~~
1)数组存储方式的分析
优点:通过下标方式访问元素，速度快。对于有序数组，还可使用二分查找提高检索速度。
缺点:如果要检索具体某个值，或者插入值(按- -定顺序)会整体移动， 效率较低。

2)链式存储方式的分析
优点:在一定程度上对数组存储方式有优化(比如:插入-个数值节点,只需要将插入节点，链接到链表中即可，删
除效率也很好)。
缺点:在进行检索时，效率仍然较低，比如(检索某个值，需要从头节点开始遍历)

3)树存储方式的分析
能提高数据存储，读取的效率，比如利用二叉排序树(Binary Sort Tree),既可以保证数据的检索速度，同时也可以
保证数据的插入，删除，修改的速度。
案例:[7,3,10,1,5,9,12] 
~~~

#### 9.1.2前中后序遍历

~~~
前序遍历:先输出父节点，再遍历左子树和右子树
中序遍历:先遍历左子树，再输出父节点，再遍历右子树
后序遍历:先遍历左子树，再遍历右子树，最后输出父节点
小结:看输出父节点的顺序，就确定是前序，中序还是后序
~~~

#### 9.1.3前中后序遍历查找

~~~
前序查找思路
1.先判断当前结点的no是否等于要查找的
2.如果是相等，则返回当前结点
3.如果不等，则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
4.如果左递归前序查找，找到结点，则返回，否继续判断，当前的结点的右子节点是否
为空，如果不空，则继续向右递归前序查找.

中序查找思路
1.判断当前结点的左子节点是否为空，如果不为空，则遵归中序查找
2.如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点，否
则继续进行右递归的中序查找
3.如果右递归中序查找,找到就返回，否则返回null

后序查找思路
1.判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
2.如果找到，就返回，如果没有找到，敦判断当前结点的右子节点是否为空，如果不为
空，则右递归进行后序查找，如果找到，就返回
3.就和当前结点进行，比如，如果是则返回，否则返回null
~~~

#### 9.1.4删除结点

~~~
规定:
1)如果删除的节点是叶子节点，则删除该节点
2)如果删除的节点是非叶子节点，则删除该子树
思路
1.因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删
除结点，而不能去判断当前这个结点是不是需要删除结点
2.如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将
this.left=null; 并且就返回(结束递归删除)
3.如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将
this.right=null;并 且就返回(结束递归删除)
4.如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
5.如果第4步也没有删除结点，则应当向右子树进行递归删除.
6.考虑如果树是空树root,如果只有一个root结点，则等价将二叉树置空

~~~



#### 9.2顺序存储二叉树

~~~
顺序存储二叉树的特点: 
1)顺序二叉树通常只考虑完全二叉树
2)第g个元素的左子节点为2*n+1
3)第h个元素的右子节点为2*n+2
4)第n个元素的父节点为(n-1)/ 2
5) n:表示二叉树中的第几个元素(按0开始编号如图所示)
~~~



#### 9.3 线索化二叉树

* **先看一个问题**

  将数列{1,3,6,8,10,14 } 构建成-颗二叉树，n+1=7；

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/plotBinaryTree.png" 
height = "400"  alt = "plotBinaryTree"/></div> <br/><br/>

  问题分析:
  1) 当我们对上面的二叉树进行中序遍历时，数列为{8,3, 10,1,6, 14}
  2)但是6,8,10,14这几个节点的左右指针，并没有完全的利用上.
  3)如果我们希望充分的利用各个节点的左右指针，让各个节 点可以指向自己的前后节点怎么办?
  4)解决方案-线索二叉树



* **线索二叉树基本介绍**
  1) n个结点的二叉链表中含有n+1 [ 公式2n-(n-1)=n+1]个空指针域。利用二叉链表中的空指针域，存放指向该结点在某种遍历次序下的前驱和后继结点的指针(这种附加的指针称为"线索")
  2)这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(Threaded BinaryTree)。根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
  3)一个结点的前一个结点，称为前驱结点
  4) - -个结点的后- -个结点，称为后继结点

  

* **思路分析**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/threadedBinaryTree.png" </div> <br/><br/>
height = "400"  alt = "线索化二叉树"/>

**说明:当线索化二叉树后，Node节点的属性left 和right ，有如下情况:**
1) left 指向的是左子树，也可能是指向的前驱节点.比如①节点left 指向的左子树，而0节点的left 指向的
就是前驱节点.
2) right 指向的是右子树，也可能是指向后继节点，比如①节点right指向的是右子树，而回节点的right指向
的是后继节点.
I

* **遍历线索化二叉树**
  **说明:**对前面的中序线索化的二叉树，进行遍历
  **分析:**因为线索化后，**各个结点指向有变化，因此原来的遍历方式不能使用**，这时需要使用新的方式遍历线索化二叉树，各个节点可以通过线型方式遍历，因此无需使用递归方式，这样也提高了遍历的效率。遍历的次序应当和中序遍历保持一致。



#### 9.4堆排序

**堆排序的基本思想是:**

1)将待排序序列构造成一个大顶堆
2)此时，整个序列的最大值就是堆顶的根节点。
3)将其与末尾元素进行交换，此时末尾就为最大值。
4)然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如.此反复执行，便能得到-一个有序序列了。
可以看到在构建大项堆的过程中，元素的个数逐渐减少，最后就得到一个有序序列了.

#### 9.5 二叉排序树（BST）

**二叉排序树介绍：**
二叉排序树: BST: (Binary Sort(Search) Tree),对于二叉排序树的任何一-个非叶子节点，要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大。
特别说明:如果有相同的值，可以将该节点放在左子节点或右子节点，比如针对前面的数据(7,3, 10,12,5,1,9)，对应的二叉排序树为:![image-20200427111814240](C:\Users\Meanlam\OneDrivejava架构师学习之路\JAVA学习笔记\images\bst.png)

**二叉排序树的删除**
二叉排字树的删除情况比较复杂，有下面三种情况需要考虑
删除叶子节点(比如: 2,5,9,12)
删除只有一颗子树的节点(比如: 1)
删除有两颗子树的节点.(比如: 7,3, 10)

**思路分析**

~~~
第一种情况:
删除叶子节点(比如: 2, 5, 9, 12)
思路
(1)需求先去找到要删除的结点targetNode
(2)找到targetNode的父结点parent
(3)确定targetNode是parent的左子结点还是右子结点
(4)根据前面的情沉来对应删除
左子结点parent.left = null
右子结点parent.right = null;

第二种情况:删除只有一颗子树的节点比如1
思路
(1)需求先去找到要删除的结，点targetNode
(2)找到targetNode的父结点parent
(3)确定targetNode的子结点是左子结点还是右子结点
(4) targetNode是parent的左子结点还是右子结点

(5)如果targetNode有左子结点
5.1 如果targetNode是parent的左子结点
parent.left = targetNode.left;
5.2 如果targetNode是parent的右子结点
parent.right = targetNode.left;

(6)如果targetNode有右子结点
6.1如果targetNode是parent 的左子结点
parent.left = targetNode.right;
6.2如果targetNode是parent的右子结点
parent.right = targetNode.right

情况三:删除有两颗子树的节点. (比如: 7,3，10)
思路
(1)需求先去找到要删除的结点targetNode
(2)找到targetNode的父结点parent
(3)从targetNode 的右子树找到最小的结点 \ 或者从targetNode的左子树找到最大的节点
(4)用一个临时变量，将最小结点的值保存temp = 11
(5)删除该最小结点
(6) targetNode.value = temp
~~~

#### 9.6平衡二叉树（AVL）

**BST不足之处：**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/左旋转.png" 
height = "400"  alt = "左旋转"/></div> <br/><br/>

**基本介绍**

~~~
1)平衡二叉树也叫平衡二叉搜索树(Self-balancing binarysearch tree)又被称为AVL树，可 以保证查询效率较高。
2)具有以下特点:它是一棵空树或它的左右两个子树的高度差的绝对值不超过1,并且左右两个子树都是一棵平衡二叉树。平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、 伸展树等。
~~~

**左旋**

~~~
当前节点的右子树的高度与左子树高度之差大于1时候，（右子树高度大，进行左旋转）；
~~~
<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/左旋转.png" 
height = "400"  alt = "左旋转"/></div> <br/><br/>
	
**右旋**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/右旋转.png" 
height = "400"  alt = "右旋转"/></div> <br/><br/>
**双旋转**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/双旋转.png" 
height = "400"  alt = "双旋转"/></div> <br/><br/>


#### 9.6多路查找树

##### **1、二叉树的问题所在**

~~~
（1）二叉树需要加载到内存的，如果二叉树的节点少，没有什么问题，但是如果二叉树的节点很多(比如1亿)，就存在如下问题:
（2）问题1:在构建二叉树时，需要多次进行i/o操作(海量数据存在数据库或文件中)，节点海量，构建二叉树时，速度有影响
（3）问题2:节点海量，也会造成二叉树的高度很大，会降低操作速度.

~~~

##### 2、**多叉树**

~~~
在二叉树中，每个节点有数据项，最多有两个子节点。如果允许每个节点可以有更多的数据项和更多的子节点就是多叉树(multiway tree)
后面我们讲解的2-3树，2-3-4 树就是多叉树，多叉树通过重新组织节点，减少树的高度，能对二叉树进行优化。
举例说明(下面2-3树就是-颖多叉树)
~~~

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/2-3树.png" 
height = "400"  alt = "2-3树"/></div> <br/><br/>

##### 3、**B树的基本介绍**

~~~
（1）如图B树通过重新组织节点，降低了 树的高度.
（2）文件系统及数据库系统的设计者利用了磁盘预读原理，将一个节点的大小设为等于一一个页(页得大小通常为4k),这样每个节点只需要一次I/O就可以完全载入
（3）将树的度M设置为1024,在600亿个元素中最多只需要4次IO操作就可以读取到想要的元素，B树(B+)广泛应用于文件存储系统以及数据库系统中
~~~

##### **4、2-3树的基本概念**

~~~
2-3树是最简单的B树结构,具有如下特点:
1) 2-3树的所有叶子节点都在同一 层.(只要是B树都满足这个条件)
2)有两个子节点的节点叫二节点，二节点要么没有子节点，要么有两个子节点.
3)有三个子节点的节点叫三节点，节要么没有子节点，要么有三个子节点.
4)2-3树是由二节点和三节点构成的树。
~~~

**插入规则**

~~~
1) 2-3树的所有叶子节点都在同- -层.(只要是B树都满足这个条件)
2)有两个子节点的节点叫二节点， 二节点要么没有子节点，要么有两个子节点
3)有三个子节点的节点叫三节点，三节点要么没有子节点，要么有三个子节点
4)当按照规则插入一个数到某个节点时， 不能满足上面三个要求，就需要拆,先向上拆，如果上层满，则拆本层，
拆后仍然需要满足.上面3个条件。
5)对于三节点的子树的值大小仍然遵守(BST二叉排序树)的规则

~~~

##### 5、B树、B+树、B*树的概念

	B-tree树即B树，B即Balanced,平衡的意思。有人把B-tree翻译成B-树，容易让人产生误解。会以为B-树是一种树，而B树又是另一种树。实际上，B-tree 就是指的B树。

**B树的介绍**
前面已经介绍了2-3树和2-3-4树，他们就是B树(英语: B-tree 也写成B-树)，这里我们再做-一个说明，我们在学
习Mysql时，经常听到说某种类型的索引是基于B树或者B+树的，如图: .

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/B树.png" 
height = "400"  alt = "B树"/></div> <br/><br/>

**B树的说明:** 

~~~
1) B树的阶: 节点的最多子节点个数。比如2-3树的阶是3，2-3-4树的阶是4
2) B-树的搜索，从根结点开始，对结点内的关键字(有序)序列进行二分查找，如果命中则结束，否则进入查询关键字所属范
   围的儿子结点:重复，直到所对应的儿子指针为空，或已经是叶子结点
3) 关键字集合分布在整颗树中， 即叶子节点和非叶子节点都存放数据.
4) 搜索有可能在非叶子结点结束
5) 其搜索性能等价于在关键字全集内做一次分查找
~~~

**B+树介绍：**


<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/B+树.png" 
height = "400"  alt = "B+树"/></div> <br/><br/>

**B+树的说明:** 

~~~
1) B+树的搜索 与B树也基本相同，区别是B+树只有达到叶子结点才命中( B树可以在非叶子结点命中)，其性能也等价于在    关键字全集做一次二分查找
2)所有关键字都出现在叶子结点的链表中(即数据只能在叶子节点[也叫稠密索引] )，且链表中的关键字(数据)恰好是有序   的。
3)不可能在非叶子结点命中
4)非叶子结点相当于是叶子结点的索引 (稀疏索引)叶子结点相当于是存储(关键字)数据的数据层
5)更适合文件索引系统
6) B树和B+树各有 自己的应用场景，不能说B+树完全比B树好，反之亦然.

~~~

 B\*树的介绍

~~~
B*树是B+树的变体，在B+树的非根和非叶子结点再增加指向兄弟的指针。
~~~

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/Bsatr树.png" 
height = "400"  alt = "Bsatr树"/></div> <br/><br/>

~~~
1) B*树定义了非叶子结点关键字个数至少为(2/3)*M， 即块的最低使用率为2/3， 而B+树的块的最低使用率为的1/2。
2)从第1个特点我们可以看出，B*树分配新缍点的概率比B+树要低，空间使用率更高
~~~

### 10、图

#### 10.1图的基本介绍

**为什么要有图**

~~~
1)前面我们学了线性表和树
2)线性表 局限于一个直接前驱和一个直接后继的关系
3)树也只能有一一个直接前驱也就是父节点
4)当我们需要表示多对多的关系时， 这 里我们就用到了图
~~~


**图的举例**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/图.png" 
height = "400"  alt = "图"/></div> <br/><br/>


**图的概念**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/图的概念.png" 
height = "400"  alt = "图的概念"/></div> <br/><br/>

**图的表示：**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/邻接矩阵.png" 
height = "400"  alt = "邻接矩阵"/></div> <br/><br/>

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/邻接表.png" 
height = "400"  alt = "邻接表"/></div> <br/><br/>


#### 10.2图的创建

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/图的创建.png" 
height = "400"  alt = "图的创建"/> </div> <br/><br/>

#### 10.3图的遍历

**图的遍历的介绍**

~~~
所谓图的遍历，即是对结点的访问。-一个图有那么多个结点，如何遍历这些结点，需要特定策略，一般有两种访问策略: (1)深度优先遍历(2)广度优先遍历。
~~~

##### 10.3.1 深度优先遍历（Depth First Search）

**基本思想**

~~~
1)深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，深度优先遍历的策略就是首先访问第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点，访问它的第一一个邻接结点，可以这样理解:每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
2)我们可以看到，这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问。
3) 显然，深度优先搜索是一个递归的过程
~~~

**基本步骤**

~~~
1)访问初始结点v，并标记结点v为已访问。
2)查找结 点v的第- -个邻接结点w。
3)若w存在， 则继续执行4，如果w不存在，则回到第1步，将从v的下一-个结点继续。
4)若w未 被访问，对w进行深度优先遍历递归(即把w当做另-一个v，然后进行步骤123)。
5)查找结点v的w邻接结点的下一一个邻接结点，转到步骤3。
~~~

**核心代码实现**

~~~java
 /************************深度优先搜索Start****************************************/

    /**
     * 查找一个顶点的第一个相邻的节点。
     * @param i 待查找第一个相邻节点的下标
     * @return -1 表示没有找到，否则返回数组的下标。
     */
    private int getFirstNeighbor(int i){
        for (int j = 0; j < getVertexs(); j++) {
            if (edges[i][j] > 0)
                return j;
        }
        return -1;
    }

    /**
     * 根据前一个相邻的顶点的下标，来获取下一个相邻的顶点。
     * @param v1 前一个相邻顶点的下标，下一个相邻顶点的下标。
     * @param v2
     * @return
     */
    private int getNextNeighbor(int v1, int v2){
        for (int j = v2+1; j < getVertexs(); j++) {
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 对一个节点的深度优先搜索
     * @param start 搜索的起始位置的下标
     */
    private void dfs(boolean[] isVisited ,int start){
        System.out.print(getValueByIndex(start) + "-->");
        //获取第一个相邻顶点的下标值：
        int w = getFirstNeighbor(start);
        isVisited[start] = true;

        //有相邻的顶点；
        while (w != -1){
           if (!isVisited[w]){
               //没有被访问，则会以当前的节点作为起始顶点递归访问
               dfs(isVisited,w);
           }
           //如果w顶点已经被访问了
           w = getNextNeighbor(start, w);

        }
    }

    /**
     * 深度优先搜索
     */
    public void dfs(){
        for (int i = 0; i < getVertexs(); i++) {
            if (!isVisited[i])
                dfs(isVisited,i);
        }

    }

    /*************************************深度优先搜索END********************/
~~~

##### 10.3.2 广度优先遍历(Broad First Search)

**基本思想**

~~~
类似于一个分层搜索的过程，广度优先遍历需要使用-一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点.
~~~

**算法步骤**

~~~
1) 访问初始结点并标记结点为已访问。
2)结点v入队列
3)当队列非空时， 继续执行，否则算法结束。
4)出队列，取得队头结点u. 
5)查找结 点u的第- -个邻接结 点w。
6) 若结点u的邻接结点w不存在，则转到步骤3;否则循环执行以下三个步骤:
	6.1若结点w尚未被访问，则访问结点w并标记为己访问。
	6.2结点w入队列
	6.3查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
~~~

**核心代码**

~~~java
 /*************************************广度优先搜索START************************/

    /**
     * 对一个节点的广度优先搜索
     * @param isVisited 顶点访问情况分析
     * @param start 节点索引
     */
    private void bfs(boolean[] isVisited, int start){
        int u; //队列头结点的下标；
        int w; //邻接节点
        LinkedList<Integer> queue = new LinkedList<>();//充当队列，记录节点访问的顺序
        System.out.print(getValueByIndex(start) + "-->");
        isVisited[start] = true;
        queue.addLast(start);
        
        while (!queue.isEmpty()){
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "-->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }

        }
    }

    /**
     * 广度优先搜索
     */
    public void bfs(){
        for (int i = 0; i < getVertexs(); i++) {
            if (!isVisited[i])
                bfs(isVisited, i);
        }
    }
 /*************************************广度优先搜索END************************/
~~~



### 									11、常用经典算法总结

#### 11.1分治算法

##### **分治算法介绍**

~~~
分治法是一种很重要的算法。字面上的解释是“分而治之”，就是把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题...直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并。这个技巧是很多高效算法的基础，如排序算法(快速排序，归并排序)，傅立叶变换(快速傅立叶变换....
~~~

##### **分治算法可以求解的一些经典问题**

* 二分搜索
* 大整数乘法
* 棋盘覆盖
* 合并排序
* 快速排序
* 线性时间选择
* 最接近点对问题
* 循环赛日程表
* 汉诺塔



##### **分治算法的基本步骤**

~~~
分治法在每一层递归上都有三个步骤:
1) 分解:将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题
2) 解决:若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题
3) 合并:将各个子问题的解合并为原问题的解。
~~~



##### **分治算法设计模式**

~~~
if |P|≤ n0
   then return(ADHOC(P))
//将P分解为较小的子问题P1 ,P2....
forik 1 to k
do yi < Divide- and-Conquer(Pi)递归解决Pi
T < MERGE(y,2,.yk)合并子问题
return(T)
~~~

其中|P|表示问题P的规模; n0为一阈值，表示当问题P的规模不超过n0时，问题已容易直接解出，不必再继续分解。ADHOC(P)是 该分治法中的基本子算法，用于直接解小规模的问题P。因此，当P的规模不超过n0时直接用算法ADHOC(P)求解。算法MERGE(yl,2,.,yk)是该分治法中的合并子算法，用于将P的子问题P1 ,P2 ..k的相应的解y1,2.,..yk合并为P的解。



##### **分治算法的应用——汉诺塔**

~~~
➢汉诺塔的传说
   汉诺塔:汉诺塔(又称河内塔)问题是源于印度一个古老传说的益智玩具。大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。

   假如每秒钟一一次，共需多长时间呢?移完这些金片需要5845.54亿年以上，太阳系的预期寿命据说也就是数百亿年。真的过了5845.54亿年， 地球上的一切生命，连同梵塔、庙宇等，都早已经灰飞烟灭。
~~~



**汉诺塔算法思路分析**

~~~
1. 如果是有一个盘，A -> C 

2. 如果我们有n>=2情况，我们总是可以看做是两个盘1.最下边的盘2..上面的盘
   1)先把最上面的盘 A -> B
   2)把最下边的盘 A -> C
   3)把B塔的所有盘从 B -> C
~~~

**核心代码实现**

~~~java
 /**
     * 分支算法——汉诺塔
     * @param nums 圆盘数量
     * @param a 柱子 A
     * @param b 柱子 B
     * @param c 柱子 C
     */
    public static void hanoiTower(int nums, char a, char b, char c){
        
        if (nums == 1) {
            conunt++; // 类变量（静态变量），用于保存搬运的次数
            System.out.println("第1个圆盘" + a + "-->" + c);
        }
        
        //如果我们有n>=2情况，我们总是可以看做是两个盘: 1.最下边的一个盘 2上面的n-1个盘
        else {
            //1)先把最上面的盘 A -> B,中间借用C作为辅助的柱子
            hanoiTower(nums-1, a, c, b);

            //2)把最下边的盘 A -> C
            System.out.println("第" + (nums-1) +"个圆盘" + a + "-->" + c);
            conunt++;
            //3)把B塔的所有盘从 B -> C,中间借用A作为辅助的柱子

            hanoiTower(nums-1, b, a, c);
        }
    }
~~~



#### 11.2动态规划算法

##### 11.2.1 动态规划算法介绍

~~~
1)动态规划(Dynamic Programming)算法的核心思想是:将大问题划分为小问题进行解决，从而一步步获取最优解的处理算法；
2)动态规划算法与分治算法类似， 其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解；
3)与分治法不同的是， 适合于用动态规划求解的问题，经分解得到子问题往往不是互相独立的。( 即下一个子阶段的求解是建立在.上一个子阶段的解的基础上，进行进一步的求解)；
4)动态规划可以通过填表的方式来逐步推进，得到最优解。
~~~

##### 11.2.2 背包问题

背包问题:有一个背包，容量为4磅，现有如下物品

| 物品 | 重量 | 价格 |
| ---- | ---- | ---- |
| 吉他 | 1    | 1500 |
| 影响 | 4    | 4000 |
| 电脑 | 3    | 2000 |

1)要求达到的目标为装入的背包的总价值最大，并且重量不超出
2)要求装入的物品不能重复

**思路分析**

~~~
●背包问题主要是指一一个给定容量的背包、若千具有一定价值和重量的物品，如何选择物品放入背包使物品的价值最大。其中又分01背包和完全背包(完全背包指的是:每种物品都有无限件可用)
●这里的问题属于01背包，即每个物品最多放-一个。而无限背包可以转化为01背包。

算法的主要思想，利用动态规划来解决。每次遍历到的第i个物品，根据w[j]和v[i]来确定是否需要将该物品放入背包中。即对于给定的n个物品，设v[i]、w[i]分别为第i个物品的价值和重量，C为背包的容量。再令v[j]i]表示在前i个物品中能够装入容量为j的背包中的最大价值。则我们有下面的结果:|

(1) v[i][0]=v[]i]=0://表示 填入表第一行和第一列是 0
(2)当w[j>j时: v[i][j]=v[i-1][j] // 当准备加入新增的商品的容量大于当前背包的容量时，就直接使用上一个单元格的装入策略
(3)当j>=w[i]时: v[i]ij=max{[i-1]i], v[ij+i[-1]j-w[i]}//当准备加入的新增的商品的容量小于等于当前背包的容量,
//装入的方式:
v[i-1]Ji]:就是 上- -个单元格的装入的最大值
v[i]:表示当前商品的价值
v[i-1][j-w[i] :装入i-1 商品，到剩余空间j-w[i]的最大值
当j>=w[i时: v[i]i]=max {v[i-1][j]. v[i]+v[i-1][j-w[i]} 
~~~

**动态规划表**

| 物品 | 0磅  | 1磅  | 2磅  | 3磅  | 4磅  |
| ---- | ---- | ---- | ---- | ---- | ---- |
|      | 0    | 0    | 0    | 0    | 0    |
| 吉他 | 0    | 1500 | 1500 | 1500 | 1500 |
| 音响 | 0    | 1500 | 1500 | 1500 | 3000 |
| 电脑 | 0    | 1500 | 1500 | 200  | 3500 |

**核心代码实现**

~~~java
public class KnapscakProblem {
    

    public static void main(String[] args){

        int[] weight = {1,4,3};
        int[] val = {1500,3000,2000};
        int size = 4;//背包的容量
        int nums = val.length; // 物品的数量

        int[][] dp = new int[nums+1][size+1]; //动态规划最优表，查表就可以知道最优解
        int[][] paths = new int[nums+1][size+1]; // 保存最优解情况下，添加了那些物品；
        
        
        for (int i = 0; i < size; i++) { //第一列（背包容量为0）始化为0，表示：当背包的容量为0的时候，任何物品都装不下，价值为0；
            dp[i][0] = 0;
        }

        for (int j = 0; j < nums; j++) {//第一行（没有物品可选）初始化为0，表示：当没有物品可选的时候，背包容量为任何值，价值为0.
            dp[0][j] = 0;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
             
                if (weight[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                    
                }else{
                    
//                    dp[i][j] = Math.max(dp[i-1][j],val[i-1] + dp[i-1][j-weight[i-1]]);// 这种方式没法记录，添加了哪些商品；

                    if (dp[i-1][j] < val[i-1] + dp[i-1][j-weight[i-1]]){ //这有这种情况下才是组合加入的；

                        dp[i][j] = val[i-1] + dp[i-1][j-weight[i-1]];
                        paths[i][j] = 1;
                    }
                    else
                        dp[i][j] = dp[i-1][j];

                }
            }
        }
        
        
        //----------------------------------------------------------------------------

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[i].length; j++) {
                
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        int i = nums;//行最大下标
        int j = size;//列最大下标

        while (i > 0 && j > 0){

            if (paths[i][j] == 1){

                System.out.printf("背包中添加的商品编号为：%d \n",i);
                j = j - weight[i-1];//剩余背包的容量；
            }

            i--;
        }     
    }
}
~~~



##### 11.2.3 KMP字符串匹配算法

**问题引入**

~~~
1)有一个字符串str1= ""尚硅谷你尚硅尚硅谷你尚硅谷你尚硅你好""，和一个子 串str2=" 尚硅谷你尚硅你"中
2)现在要判断str1是否含有str2,如果存在，就返回第一次出现的位置，如果没有，则返回-1
~~~

**暴力匹配算法的实现**

~~~java
public class ViolenceMatch {

    public static void main(String[] args){
        String str1 = "dbaisjdaksifovasnfoas";
        String str2 = "ifova";
        System.out.println("index = " + violenceMatch(str1,str2));
    }
    /**
     * 暴力匹配算法,判断 str1 中是否包含 str2
     * @param str1 原始字符串
     * @param str2 正则字符串
     * @return 匹配位置的索引 ，找不到则返回-1
     */
    public static int violenceMatch(String str1, String str2){

      char[] s1 = str1.toCharArray();
      char[] s2 = str2.toCharArray();

      int s1Len = s1.length;
      int s2Len = s2.length;

      int index1 = 0;
      int index2 = 0;

      while (index1 < s1Len && index2 < s2Len){

          if (s1[index1] == s2[index2]){
              index1++;
              index2++;

          }else { // 匹配失败，回溯重新匹配

              index1 = index1 - (index2-1);
              index2 = 0;
          }
      }

      if (index2 == s2Len){
          return index1 - index2;
      }
      else
          return -1;
    }
}

~~~

**KMP 算法介绍**

~~~
1) KMP是一个解决模式串在文本串是否出现过，如果出现过，最早出现的位置的经典算法
2) Knuth-Mris-Pratt 字符串查找算法，简称为“KMP算法” ，常用于在-一个文本串S内查找-一个模式串P的出现位置，这个算法由Donald Knuth、Vaughan Pratt、James H. Moris三人于1977年联合发表，故取这3人的姓氏命名此算法
3) KMP方法算法就利用之前判断过信息，通过一个next数组，保存模式串中前后最长公共子序列的长度，每次回溯时，通过next数组找到，前面匹配过的位置，省去了大量的计算时间；
4)参考资料: https://www.cnblogs.com/zzuuoo666/p/9028287.html
~~~

**核心代码实现**

~~~java
public class KMPMatch {

    public static void main(String[] args){

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext(str2);
        System.out.println("next = " + Arrays.toString(next));
        
        System.out.println("index = " + kmpSearch(str1,str2,next));
    }

    /**
     * 部分匹配表；
     * @param des
     * @return
     */
    public static int[] kmpNext(String des){

        int[] next = new int[des.length()];
        next[0] = 0; // 表示：当只有一个字符的时候，它没有前缀，也没有后缀，此时前缀与后缀的部分匹配情况为0
        for (int i = 1,j = 0; i < des.length(); i++) {
            
            while (j > 0 && des.charAt(i) != des.charAt(j)){
                j = next[j-1];
            }
            if (des.charAt(i) == des.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     *
     * @param str1 源字符串
     * @param str2 模式字符串
     * @param next 部分匹配表
     * @return -1 表示没有找到，其它值表示第一次匹配时的下标
     */
    public static int kmpSearch(String str1, String str2, int[] next){

        for (int i = 0,j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }

            if (j == str2.length())
                return i-j +1;
        }

        return -1;
    }
}
~~~

#### 11.3 贪心算法

##### **应用场景——集合覆盖问题**

~~~
假设存在下面需要付费的广播台，以及广播台信号可以覆盖的地区。如何选择最少的广播台，让所有的地区都可以接收到信号
~~~

| 广播台 | 覆盖地区       |
| ------ | -------------- |
| K1     | 北京 上海 天津 |
| K2     | 广州 北京 深圳 |
| K3     | 成都 上海 杭州 |
| K4     | 上海 天津      |
| K5     | 杭州 大连      |

##### **贪心算法介绍**

~~~
1)贪婪算法(贪心算法)是指在对问题进行求解时，在每一步选择中都采取最好或者最优(即最有利)的选择，从而希望能够导致结果是最好或者最优的算法
2)贪婪算法所得到的结果不一定 是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果
~~~

**思路分析**

~~~
如何找出覆盖所有地区的广播台的集合呢，使用穷举法实现,列出每个可能的广播台的集合，这被称为幂集。假设总的有n个广播台，则广播台的组合总共有2^n-1个,假设每秒可以计算10个子集，如图:
~~~

| 广播台数量 | 子集总数2^n | 需要的时间 |
| ---------- | ----------- | ---------- |
| 5          | 32          | 3.2s       |
| 10         | 1024        | 102.4秒    |
| 32         | 429496729   | 13.6年     |
| 100        | 1.26*100^30 | 64x10^23年 |

**贪心算法求解**

~~~
➢使用贪婪算法，效率高:
目前并没有 算法可以快速计算得到准备的值，使用贪婪算法，则可以得到非常接i近的解，并且效率高。选择策略上，因为需要覆盖全部地区的最小集合: 堂遍历所有的广播电台，找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系)
2)将这个电台加入到一个集合中(比如ArrayList),想办法把该电台覆盖的地区在下次比较时去掉。
3)重复第1步直到覆盖了全部的地区
~~~

**核心代码**

~~~java
public class GreedyAlgo {

    public static void main(String[] args){
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        
        HashSet<String> allAreas = new HashSet<>();
        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);
        
        System.out.println("allAreas = "+allAreas);


        ArrayList<String> selects = new ArrayList<>(); //保存选中的结果；
        
        String maxKey = ""; // 记录每次循环过后，覆盖区域最多的key

        while (allAreas.size() != 0){

            maxKey = null;

            for(String key : broadcasts.keySet()){

                HashSet<String> broadcastArea = broadcasts.get(key);
                broadcastArea.retainAll(allAreas);

                if (broadcastArea.size() > 0 && (maxKey == null || broadcastArea.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            if (maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }
        
        System.out.println("selects = " + selects);

    }
}
~~~

##### **贪心算法注意事项和细节**

~~~
(1)贪婪算法所得到的结果不一定 是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果
(2)比如上题的算法选出的是K1, K2,K3, K5，符合覆盖了全部的地区
(3)但是我们发现K2,K3,K4,K5也可以覆盖全部地区，如果K4的使用成本低于K1,那么我们上题的K1,K2,K3,K5虽然是满足条件，但是并不是最优的.
~~~



#### 11.4 普利姆算法

**应用场景——修路问题**

| 问题描述                                                     | 场景图                                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1)有胜利乡有7个村庄(A,B,C,D,E,F,G)， 现在需要修路把7个村庄连通<br/>2)各个村庄的距离用边线表示(权)，比如A-B距离5公里<br/>3) 问:如何修路保证各个村庄都能连通，并且总的修建公路总里程最短?<br/>思路:将10条边，连接即可，但是总的里程数不是最小.<br/>**正确的思路，就是尽可能的选择少的路线，并且每条路线最小，保证总里程数最少.** | ![image-20200603170548700](C:\Users\Meanlam\OneDrive\java架构师学习之路\JAVA学习笔记\images\prim.png) |

##### 最小生成树

~~~
修路问题本质就是就是最小生成树问题，先介绍一下最小生成树(Minimum Cost Spanning Tree),简称 MST.
1) 给定一个带权的无向连通图,如何选取一棵生成树,使树上所有边上权的总和为最小，这叫最小生成树
2) N个顶点，一定有N-1条边
3) 包含全部顶点
4) N-1条边都在图中
5) 举例说明(如图:)
6) 求最小生成树的算法主要是普里姆算法和克鲁斯卡尔算法
~~~

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/生成图.png" 
height = "400"  alt = "生成图"/></div> <br/><br/>

##### **普利姆算法的介绍**

~~~
普利姆(Prim)算法求最小生成树，也就是在包含n个顶点的连通图中，找出只有(n-1)条边包含所有n个顶点的连通子图，也就是所谓的极小连通子图。
普利姆的算法如下:
1) 设G=(V,E)是连通网， T=(U,D)是最小生成树，V,U是顶点集合，E,D是边的集合
2)若从顶点u开始构造最小生成树，则从集合V中取出顶点u放入集合U中，标记项点v的visited[u]=1
3) 若集合U中顶点ui与集合V_U中的顶点vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路，将.
顶点vj加入集合U中，将边(ui,vj) 加入集合D中，标记visited[vj]=1
4) 重复步骤②，直到U与V相等，即所有顶点都被标记为访问过，此时D中有n-1条边
5)提示: 单独看步骤很难理解，我们通过代码来讲解，比较好理解.
6) 图解普利姆算法
~~~

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/prim算法介绍.png" 
height = "400"  alt = "prim算法介绍"/></div> <br/><br/>

**核心代码**

~~~java
public class PrimAlgo {

    public static final int NAN = Integer.MAX_VALUE; // 表示两个节点之间是不连通的；
    public static void main(String[] args){

        char[] vertexName = new char[]{'A','B','C','D','E','F','G'};
        int vertexNums = vertexName.length;
        int[][] weights = new int[][]{
        {NAN, 5,7,NAN , NAN, NAN,2},
        {5, NAN, NAN,9, NAN, NAN,3},
        {7,NAN, NAN , NAN, 8, NAN, NAN},
        {NAN, 9, NAN, NAN, NAN ,4, NAN},
        {NAN, NAN, 8, NAN,NAN,5,4},
        {NAN, NAN, NAN,4, 5, NAN,6},
        {2,3, NAN, NAN,4,6, NAN},};

        MGraph graph = new MGraph(vertexNums);

        MSTree msTree = new MSTree();
        msTree.createMsTree(graph, vertexNums, vertexName, weights);
        msTree.showWeights(graph);

        msTree.prim(graph, 3);

    }
}



class MSTree{

    public void createMsTree(MGraph graph, int vertexNums, char[] vertexName, int[][] weights){

        for (int i = 0; i < vertexNums; i++) {
            graph.vertexName[i] = vertexName[i];
            for (int j = 0; j < vertexNums; j++) {
                graph.weight[i][j] = weights[i][j];
            }
        }
    }

    public void showWeights(MGraph graph){

        for (int[] link : graph.weight){
            
            System.out.println(Arrays.toString(link));
        }

    }

    /**
     *
     * @param graph 原始图
     * @param index 初始访问的节点索引
     */
    public void prim(MGraph graph, int index){

        boolean[] visited = new boolean[graph.vertexNums];
        visited[index] = true;

        int minWeight = Integer.MAX_VALUE;//路径不通
        int preIndex = -1; // 表示访问过的节点
        int postIndex = -1; // 表示还没有访问过的节点

        int mileage = 0;

        for (int k = 1; k < graph.vertexNums; k++) {

            for (int i = 0; i < graph.vertexNums; i++) {
                for (int j = 0; j < graph.vertexNums; j++) {
                    //找到当前节点到其他未访问过的节点之间权值最小的那个节点
                   if (visited[i] && !visited[j] && graph.weight[i][j] < minWeight){
                       minWeight = graph.weight[i][j];
                       preIndex = i;
                       postIndex = j;
                   }
                }
            }

            System.out.println("Edge <" + graph.vertexName[preIndex] + "————" + graph.vertexName[postIndex] + "> " + minWeight);
            mileage += minWeight;

            visited[postIndex] = true;
            minWeight = Integer.MAX_VALUE;

        }
        System.out.println("总里程为： "+mileage);

    }
}

class MGraph{
    int vertexNums; // 节点的个数
    char[] vertexName; // 节点的名字
    int[][] weight; //邻接矩阵，表示修路的权重 

    public MGraph(int vertexNums) {
        this.vertexNums = vertexNums;
        vertexName = new char[vertexNums];
        weight = new int[vertexNums][vertexNums];
    }
}
~~~

##### 克鲁斯卡尔算法的介绍

**问题引入**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/公交站问题.png" 
height = "400"  alt = "公交站问题"/></div> <br/><br/>

~~~
1) 某城市新增7个站点(A,B,C,D,E,F,G)，现在需要修路把7个站点连通
2) 各个站点的距离用边线表示(权)，比如A-B距离12公里
3) 问:如何修路保证各个站点都能连通，并且总的修建公路总里程最短
~~~

**克鲁斯卡尔算法的基本介绍**

~~~
1)克鲁斯卡尔(Kruskal)算法， 是用来求加权连通图的最小生成树的算法。
2)基本思想:按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路
3) 具体做法:首先构造一个只含n个顶点的森林，然后依权值从小到大从连通网中选择边加入到森林中，并使森林中不产生回路，直至森林变成一棵树为止
~~~

**核心代码**

~~~java
package data.algo.mst;

import java.util.*;

/**
 * @author meanlam
 * @date 2020/6/6-11:04
 */
public class KrusKalAlgo {

    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;

    private static final int INF = Integer.MAX_VALUE;

    public KrusKalAlgo(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;

        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF)
                    edgeNum++;
            }
        }
    }

    public void print(){
        System.out.println("邻接矩阵为：");
        for (int[] link : matrix){
            for (int i = 0; i < link.length; i++) {
                if (link[i] == INF)
                    System.out.printf("%5s","INF");
                else
                    System.out.printf("%5d",link[i]);
            }
            System.out.println();

        }
    }

    public List<Edge> createEdges(){
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {

                if (matrix[i][j] != INF)
                    list.add(new Edge(vertexs[i],vertexs[j],matrix[i][j]));
            }
        }
        return list;
    }

    /**
     * 获取 index 索引对应的顶点的终点；
     * @param ends
     * @param index
     * @return
     */
    private int getEnd(int[] ends, int index){

        while (ends[index] != 0){
            index = ends[index];
        }

        return index;
    }

    private Map<Character,Integer> createMap(){

        Map<Character,Integer> maps = new HashMap<>();
        for (int i = 0; i < vertexs.length; i++) {
            maps.put(vertexs[i],i);
        }

        return maps;
    }

    public List<Edge> kruskal(){

        int[] ends = new int[edgeNum];//保存已经存在的节点，用于检测已有最小生成树中是否会形成环
        List<Edge> mstResult = new ArrayList<>();
        List<Edge> edges = createEdges();
        Collections.sort(edges);
        Map<Character, Integer> posMap = createMap();

        for (Edge edge : edges){

            int start_index = posMap.get(edge.start);
            int end_index = posMap.get(edge.end);

            int ends_start = getEnd(ends,start_index);
            int ends_end = getEnd(ends,end_index);

            if (ends_start != ends_end){
                mstResult.add(edge);
                ends[ends_start] = ends_end;
            }
        }

        return mstResult;
    }



    public static void main(String[] args){

    char[] vertex = {'A','B','C','D','E','F','G'};
    int[][] matrix = {
               /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
        /*A*/ { 0,12, INF, INF, INF, 16, 14},
        /*B*/ { 12, 0, 10,INF, INF, 7, INF},
        /*C*/ { INF, 10, 0, 3, 5, 6, INF},
        /*D*/ { INF, INF, 3, 0, 4, INF, INF},
        /*E*/ { INF, INF, 5, 4, 0, 2, 8},
        /*F*/ { 16,   7, 6, INF, 2, 0, 9},
        /*G*/ { 14, INF, INF, INF, 8, 9, 0}};

        KrusKalAlgo krusKal = new KrusKalAlgo(vertex, matrix);
        krusKal.print();


        List<Edge> lists = krusKal.createEdges();
        System.out.println("原始边：");
        for (Edge edge : lists){
            System.out.println(edge);
        }

        System.out.println("排序后的边：");
        Collections.sort(lists);
        for (Edge edge : lists){
            System.out.println(edge);
        }

        System.out.println("最小生成树：");
        List<Edge> mst = krusKal.kruskal();
        for (Edge edge : mst){
            System.out.println(edge);
        }
    }
}

class Edge implements Comparable<Edge>{

    char start; // 一条边的左顶点
    char end;   // 一条边的右顶点
    int weight; // 边上面的权重

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge<" + start + "—————— + " + end + "> weight = " + weight ;
    }


    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}
~~~

#### 11.5迪杰斯特拉算法

**应用场景**

| 场景图                                                       | 问题描述                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| <div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/prim.png" 
  height = "400"  alt = "普利姆"/> </div> <br/><br/> | 1) 战争时期，胜利乡有7个村庄(A, B, C,D,E,F,G)，现在有六个邮差，从G点出发，需要分别把邮件分别送到A,B,C,D,E,F六个村庄<br/>2)各个村庄的距离用边线表示(权)，比如A - B距离5公里<br/>3) 间:如何计算出G村庄到其它各个村庄的最短距离?<br/>4)如果从其它 点出发到各个点的最短距离又是多少? |



**迪杰斯特拉(Dijkstra)算法介绍**

~~~
迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个结点到其他结点的最短路径。它的主要特点是以
起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止。
~~~

**迪杰斯特拉(Dijkstra)算法过程**

~~~
设置出发项点为v，顶点集合V{v1,v2,vi..}, v到V中各顶点的距离构成距离集合Dis,Dis{d1,d2,di..}, Dis集合记录着v到图中各顶点的距离(到自身可以看作0，v到vi距离对应为di);
1) 从Dis中选择值最小的di并移出Dis集合，同时移出V集合中对应的顶点vi,此时的v到vi即为最短路径;
2) 更新Dis集合， 更新规则为:比较v到V集合中顶点的距离值，与v通过vi到V集 合中顶点的距离值，保留值较小的一个(同时也应该更新顶点的前驱节点为vi,表明是通过vi到达的);
3)重复执行两步骤，直到最短路径顶点为目标顶点即可结束;
~~~

**迪杰斯特拉(Dijkstra)算法图解**

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/迪杰斯特拉.png" 
height = "400"  alt = "迪杰斯特拉"/>

**核心代码**

~~~java
package data.algo.dijkstra;

import javax.xml.bind.Binder;
import java.util.Arrays;

/**
 * @author meanlam
 * @date 2020/6/8-16:10
 */
public class DijkstraAlo {

    private static final int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args){

        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[][]{
                {INF, 5,7,INF , INF, INF,2},
                {5, INF, INF,9, INF, INF,3},
                {7,INF, INF , INF, 8, INF, INF},
                {INF, 9, INF, INF, INF ,4, INF},
                {INF, INF, 8, INF,INF,5,4},
                {INF, INF, INF,4, 5, INF,6},
                {2,3, INF, INF,4,6, INF},};

        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        graph.dijkstra(6);
        graph.showResult(6);
    }
}

class VisitedVertex{

    private int[] already_vi; // 记录各个节点是否被访问过，1表示访问过了，0表示还没有被访问过,会动态的更新
    private int[] pre_vi; // 每个下标对应的值为前一个节点的下标，会动态的更新
    private int[] dis; // 记录出发节点到其他各个顶点的距离，会动态的更新；
    private static final int INF = Integer.MAX_VALUE/2;
    /**
     * 初始化各个数组
     * @param len 节点的个数
     * @param index 开始访问的节点的下标
     */
    public VisitedVertex(int len, int index) {

        already_vi = new int[len];
        pre_vi = new int[len];
        dis = new int[len];
        
        already_vi[index] = 1;
        Arrays.fill(dis, INF);
        dis[index] = 0;
    }

    /**
     * 判断 index下标的所对应的节点是否被访问过了
     * @param index
     * @return
     */
    public boolean in(int index){
        return already_vi[index] == 1;
    }

    /**
     * 更新出发节点到index节点的距离
     * @param index 目标节点的索引
     * @param len 更新的距离
     */
    public void updateDis(int index, int len){
        dis[index] = len;
    }

    /**
     * 更新节点pre的前驱节点为index结果
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index){
        pre_vi[pre] = index;
    }

    /**
     * 获取节点到index节点的距离
     * @param index
     * @return
     */
    public int getDis(int index){
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问节点，比如这里的G访问结束之后，就是A点作为访问顶点（注意不是出发顶点）
     * 其实就是在找没有访问过的节点中距离最小的那个节点作为下次访问的节点
     * @return
     */
    public int updateAlreadyVisited(){

        int min = INF, index = 0;
        for (int i = 0; i < already_vi.length; i++) {

            if (!in(i) && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        already_vi[index] = 1;
        return index;
    }

    public void showFinalDis(int index){
        char[] vertex = {'A','B','C','D','E','F','G'};
        System.out.println("===========迪杰斯特拉最短路径结果==========");
        for (int i = 0; i < dis.length; i++) {
            System.out.println(vertex[index] + "————>"+ vertex[i] + " : " + dis[i]);
        }
    }

}

class Graph{

    char[] vertex;
    int[][] matrix;
    VisitedVertex vv;
    private static final int INF = Integer.MAX_VALUE/2;
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph(){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == INF)
                    System.out.printf("%5s","INF");
                else
                    System.out.printf("%5d",matrix[i][j]);
            }
            System.out.println();
        }

    }

    public void dijkstra(int index){
        vv = new VisitedVertex(vertex.length, index);
        update(index);

        for (int i = 1; i < vertex.length ; i++) {
            index = vv.updateAlreadyVisited();
            update(index);
        }

    }

    public void showResult(int index){
        vv.showFinalDis(index);
    }

    /**
     * 一次遍历的更新
     */
    private void update(int index){
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {

            // 出发顶点到index 节点的距离 + index节点到 i 节点的距离之和 （弯路）
            len = vv.getDis(index) + matrix[index][i];

            //当 i 这个节点还没有被访问过，且 len 小于出发顶点直接到i这个顶点的距离（直路）时，需要更新
            if (!vv.in(i) && len < vv.getDis(i)){

                vv.updateDis(i, len);
                vv.updatePre(i, index);
            }
        }
    }
}
~~~

#### 11.6弗洛伊德算法

**弗洛伊德（Floyd）算法介绍**

~~~
1)和Dijkstra算法一样，弗洛伊德(Floyd)算法也是一种用于寻找给定的加权图中顶点间最短路径的算法。该算法名称以创始人之一、1978年图灵奖获得者、斯坦福大学计算机科学系教授罗伯特弗洛伊德命名。
2)弗洛伊德算法(Floyd)计算图中各个顶点之间的最短路径。
3)迪杰斯特拉算法用于计算图中某--个顶点到其他顶点的最短路径。
4)弗洛伊德算法yS迪杰斯特拉算法:迪杰斯特拉算法通过选定的被访问顶点，求出从出发访问顶点到其他顶点的最短路径;弗洛伊德算法中每一个顶点都是出发访问点，所以需要将每一个顶点看做被访问顶点，求出从每一个顶点到其他顶点的最短径。
~~~

**弗洛伊德(Floyd)算法图解分析**

~~~
1)设置顶点vi到顶点vk的最短路径己知为Lik，顶点vk到vj的最短路径已知为Lkj,顶点vi到vj的路径为Lij，则vi到vj的最短 路径为: min(Lik(Lj),Lj), vk的取值为图中所有顶点，则可获得vi到vj的最短路径
2)至于vi到vk的最短路径Lik或者vk到vj的最短路径Lkj，是以同样的方式获得
3)弗洛伊德(Floyd)算法图解分析举例说明
~~~

<div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/floyd.png" 
height = "400"  alt = "弗洛伊德"/>

**算法应用——最短路径**

| 问题描述                                                     | 场景图                                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1) 胜利乡有7个村庄(A, B,C,D,E,F,G)<br/>2)各个村庄的距离用边线表示(权)，比如A-B距离5公里<br/>3)问: 如何计算出各村庄到其它各村庄的最短距离? | <div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/prim.png" 
                                                                                               height = "400"  alt = "普利姆"/> </div> style="zoom:70%;" /> |

**核心代码**

~~~java
package data.algo.floyd;

import java.util.Arrays;

/**
 * @author meanlam
 * @date 2020/6/9-9:48
 */
public class FloydAlgo {

    private static final int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args){

        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[][]{
                {0, 5,7,INF , INF, INF,2},
                {5, 0, INF,9, INF, INF,3},
                {7,INF, 0 , INF, 8, INF, INF},
                {INF, 9, INF, 0, INF ,4, INF},
                {INF, INF, 8, INF,0,5,4},
                {INF, INF, INF,4, 5, 0,6},
                {2,3, INF, INF,4,6, 0},};

        Graph graph = new Graph(vertex.length, vertex, matrix);
        graph.floyd();
        graph.show();
    }
}

class Graph{

    private char[] vertex;
    private int[][] dis; // 存放节点之间的最短路径
    private int[][] pre; // 存放节点的前驱节点
    private static final int INF = Integer.MAX_VALUE/2;

    public Graph(int len, char[] vertex, int[][] dis) {
        this.vertex = vertex;
        this.dis = dis;

        pre = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void floyd(){

        int len = 0;
        for (int k = 0; k < vertex.length; k++) { //对中间节点遍历[A - G]

            for (int i = 0; i < vertex.length; i++) { // 出发节点的遍历[A - G]
                for (int j = 0; j < vertex.length; j++) { // 到达目标节点的遍历[A - G]

                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]){
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }

                }
            }
        }
    }


    public void show(){

        System.out.println("距离表");
        for (int i = 0; i < vertex.length; i++) {

            for (int j = 0; j < vertex.length; j++) {

                if (dis[i][j] == INF)
                {
                    System.out.printf("<%10s>",vertex[i] +"——"+ vertex[j]+" INF");
                    System.out.print("  ");
                }

                else{
                    System.out.printf("<%10s>",vertex[i]+"——"+ vertex[j]+ " "+ dis[i][j]);
                    System.out.print("  ");
                }


            }
            System.out.println();

        }

        System.out.println("----------------------------------");
        System.out.println("前驱表：");
        for (int i = 0; i < vertex.length; i++) {

            for (int j = 0; j < vertex.length; j++) {

              System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();

        }
    }
}
~~~

#### 11.7骑士周游问题——马踏棋盘算法

**1、算法引入**

| 题目描述                                                     | 对应图解                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1)马踏棋盘算法也被称为骑士周游问题<br/>2)将马随机放在国际象棋的8X8棋盘Board[0~ 7][0~7]的某个方格中，马按走棋规则(马走日字)进行移动。要求每个方格只进入一次，走遍棋盘上全部64个方格<br/>3)游戏演示:http://www.4399.com/flash/1462672.html | <div align=center> <img src="https://github.com/Onemeaning/java-data-structure-and-algorithm/tree/master/pictures/马踏棋盘.png" 
                                                                                                                                                                height = "400"  alt = "马踏棋盘"/></div>  style="zoom:80%;" /> |



**2、算法的思路**

~~~
1)马踏棋盘问题(骑士周游问题)实际上是图的深度优先搜索(DFS)的应用。
2)如果使用回溯(就是深度优先搜索)来解决，假如马儿踏了53个点，如图:走到了第53个，坐标中(1,0) ，发现已经走到尽头，没办法，那就只能，回退了，查看其他的路径，就在棋盘上不停的回溯。
【思路】
1.创建棋盘chessBoard,是一个二维数组
2.将当前位置设置为已经访问，然后根据当前位置,计算马儿还能走哪些位置,并放入到一个集合中(ArrayList),最多有8个位置，每走-步，就使用step+1
3.遍历Arraylist中存放的所有位置,看看哪个可以走通，如果走通，就继续，走不通，就回溯.
4.判断马儿是否完成了任务，使用step和应该走的步数比较，如果没有达到数量，则表示没有完成任务，将整个棋盘置o
注意:马儿不同的走法(策略)，会得到不同的结果，效率也会有影响(优化)
//创建一个Point
Point p1 = new Point();
if((p1.x= curPoint.x - 2) >= 0 && (p1.y= curPoint.y-1)>= 0){
ps.add(new Point(1); .
}
-----------------------------------------------------------------------------------------
3) 分析第一种方式的问题，并使用贪心算法(greedyalgorithm)进行优化。解决马踏棋盘问题.
4)使用前面的游戏来验证算法是否正确。
~~~

**贪心算法对原来的算法优化**

~~~
1、我们获取当前位置，可以走的下一个位置的集合
//获取当前位置可以走的下一个位置的集合
ArrayList<Point> ps = next(new Point(column, row));
2、我们需要对fps中所有的oint的下-步的所有集合的数目,进行非递减排序就ok,
9, 7, 6, 5, 3,2, 1//递影排序
1, 2, 3, 43.6, 10,//递增推序
1,2,2, 2,3,3,4,5, 6//非递视
9, 7, 6, 6,6,5, 5,3, 2, 1 //非递增
~~~

**核心代码实现**

~~~java
package data.algo.greedy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HorseChessboard {

    private static int X;//棋盘的行数
    private static int Y; //棋盘的列数；

    //表示棋盘的某个位置是否被访问
    private static boolean[][] visited;

    //表示访问是否完成了
    private static boolean finished;


    public static void main(String[] args){

        X = 6;
        Y = 6;
        visited = new boolean[X][Y];
        int[][] chessboard = new int[X][Y];

        //初始位置
        int priX = 2;
        int priY = 4;

        System.out.println("马踏棋盘算法开始运行……");
        long start = System.currentTimeMillis();
        travesalChessboard(chessboard,priX-1,priY-1,1);

        for(int[] row : chessboard){
            for (int step : row){
                System.out.print(step +"\t");
            }
            System.out.println();
        }

        System.out.println("总共耗时为：" + (System.currentTimeMillis() - start) + "ms" );

    }

    /**
     * 马踏棋盘算法：
     * @param chess 棋盘，用于保存走的步骤
     * @param x 初始点的行数
     * @param y 初始点的列数
     * @param step 走的步数
     */
    public static void travesalChessboard(int[][] chess,int x, int y, int step){

        chess[x][y] = step;
        visited[x][y] = true;
        List<Point> ps = next(new Point(x, y));
        sort(ps);
        while (!ps.isEmpty()){

            Point point = ps.remove(0);
            if (!visited[point.x][point.y]){
                travesalChessboard(chess,point.x,point.y,step+1);
            }
        }

        // 如果走的步数没有达到棋盘的数量，说明没有走完，
        if (step < X*Y && !finished){
            chess[x][y] = 0;  //回溯，表示该点往下是走不通的；
            visited[x][y] = false;
        }
        else {
            finished = true;
        }
    }

    /**
     * 获取每一个点，接下来可以走的所有的点的位置；
     * @param cur
     * @return
     */
    public static List<Point> next(Point cur){

        List<Point> ps = new ArrayList<>();
        Point p1 = new Point();

        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y -1) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y -2) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y -2) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y -1) >=0 ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y +1) < Y ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y +2) < Y ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y +2) < Y ){
            ps.add(new Point(p1));
        }

        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y + 1) < Y ){
            ps.add(new Point(p1));
        }

        return ps;
    }

    //对下一步要走的每一个点进行排序，排序原则，每个点下一步要走的点的个数越多，回溯的可能性越大，
    //因此按照要走点的个数从少到多进行排序
    public static void sort(List<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int c1 = next(o1).size();
                int c2 = next(o2).size();

                if (c1 < c2){
                    return -1;
                }else if (c1 == c2){
                    return 0;
                }
                else
                    return 1;
            }
        });
    }
}
~~~

