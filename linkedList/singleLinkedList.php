<?php
/**
 * @file singleLinkedList.php
 * @author lurenzhong@xiaomi.com
 * @brief 单链表
 */

/** 定义结点的结构 */
class node
{
    public $index; //结点的索引
    public $data; //结点的数据域
    public $next; //指向下一个结点

    public function __construct($index, $data)
    {
        $this->index = $index;
        $this->data= $data;
        $this->next = null;
    }
}

/**
 * 单链表
 */
class singleLinkedList
{
    private $headNode; //链表头结点

    /**
     * 初始化链表头结点
     */
    public function __construct()
    {
        $this->headNode = new node(null, null);
    }

    /**
     * 插入指定索引的结点
     * @param $node
     */
    public function insertNode($node)
    {
        $current = $this->headNode;

        if( $current->next == null ){
            $current->next = $node;
        }else{
            //从头结点开始遍历，判断要插入结点的索引位置
            while( $current->next != null ){
                if( $current->next->index > $node->index ){
                    $node->next = $current->next;
                    $current->next = $node;
                    break;
                }

                $current = $current->next;
            }
        }

    }

    /**
     * 删除指定索引的结点
     * @param $index
     * @return boolean
     */
    public function delNode($index)
    {
        $current = $this->headNode;

        $isDel = false;
        while( $current->next != null ){
            if( $current->next->index == $index ){ //匹配要删除的索引
                $current->next = $current->next->next;
                $isDel = true;
                break;
            }

            $current = $current->next;
        }
        
        return $isDel;
    }

    /**
     * 根据索引查找指定结点
     */
    public function findNode($index)
    {
        $current = $this->headNode;

        while( $current->next != null ){
            if( $current->next->index == $index ){
                echo "查找到索引为: {$index} 的结点的data为: {$current->next->data} \n";
                break;
            }
            $current = $current->next;
        }

    }

    /**
     * 获取单链表的长度(不包含头结点)
     */
    public function getLinkLength()
    {
        $i = 0;
        $current = $this->headNode;
        while( $current->next != null ){
            $i++;
            $current = $current->next;
        }

        return $i;
    }

    /**
     * 获取单链表
     */
    public function getLinkedList()
    {
        $current = $this->headNode;

        if( $current->next == null ){
            echo '单链表是空的';
            exit;
        }

        //遍历每一个结点
        while( $current->next != null ){
            echo "index: {$current->next->index}, data: {$current->next->data} \n";

            $current = $current->next;
        }

    }

    

}


$singleLinkedList = new singleLinkedList();

/** 测试插入结点 */
$singleLinkedList->insertNode( new node(3,22) );
$singleLinkedList->insertNode( new node(1,12) );
$singleLinkedList->insertNode( new node(2,20) );

//print_r($singleLinkedList);exit;

/** 获取单链表长度 */
$linkLength = $singleLinkedList->getLinkLength();
//echo $linkLength. "\n"; // 3

/** 测试删除结点 */
$singleLinkedList->delNode(2);
//print_r($singleLinkedList);exit;

/** 测试获取单链表 */
$singleLinkedList->getLinkedList();

/** 测试根据索引查找结点 */
$singleLinkedList->findNode(1);
