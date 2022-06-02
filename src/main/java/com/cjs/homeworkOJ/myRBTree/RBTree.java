package com.cjs.homeworkOJ.myRBTree;

/**
 * @author jinsheng
 * @date 2021年12月14日 17:02
 */
public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }

    //左旋,这里是已经判断了要左旋，所以不存在不能左旋的情况
    //所谓的左旋，指的是向左方向旋，那么应该是右边比较多，也就是RightRight的情况
    private void leftRotate(RBNode p) {
        if (p != null) {
            RBNode pF = p.parent;
            RBNode pR = p.right;
            RBNode pRL = pR.left;
            p.right = pRL;
            pR.left = p;
            p.parent = pR;
            if (pRL != null) {
                pRL.parent = p;
            }
            pR.parent = pF;
            if (pF == null) root = pR;
            else {
                if (pF.left == p) {
                    pF.left = pR;
                } else {
                    pF.right = pR;
                }
            }
        }
    }

    //右旋,这里是已经判断了要右旋，所以不存在不能右旋的情况
    //也就是leftleft的情况
    private void rightRotate(RBNode p) {
        if (p != null) {
            RBNode pF = p.parent;
            RBNode pL = p.left;
            RBNode pLR = pL.right;
            pL.right = p;
            p.left = pLR;
            p.parent = pL;
            if (pLR != null) {
                pLR.parent = p;
            }
            pL.parent = pF;
            if (pF == null) root = pL;
            else {
                if (pF.left == p) {
                    pF.left = pL;
                } else {
                    pF.right = pL;
                }
            }
        }
    }

    private RBNode predecessor(RBNode node) {
        if (node == null) {
            return null;
        } else if (node.left != null) {//如果有左儿子
            RBNode p = node.left;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        } else if (node.parent != null) { //如果没有左儿子，但是有祖先
            RBNode p = node.parent;
            RBNode c = node;
            while (p != null && p.left == c) {
                c = p;
                p = p.parent;
            }
            return p;
        }
        //如果没有左儿子，没有祖先，那么相当于没有前驱
        return null;
    }

    //后继,这里删除使用后继节点
    private RBNode successor(RBNode node) {
        if (node == null) {
            return null;
        } else if (node.right != null) {
            RBNode p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else if (node.parent != null) {
            RBNode p = node.parent;
            RBNode c = node;
            while (p != null && p.right == c) {
                c = p;
                p = p.parent;
            }
            return p;
        }
        return null;
    }

    private RBNode getNode(K key) {
        if (key == null) return null;
        RBNode node = root;
        while (node != null) {
            int cmp = key.compareTo((K) node.getKey());
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node;
        }
        return null;
    }

    private void setColor(RBNode node, boolean color) {
        if (node != null) {
            node.setColor(color);
        }
    }

    private boolean colorOf(RBNode node) {
        return node == null ? BLACK : node.color;
    }

    private RBNode parentOf(RBNode node) {
        return node != null ? node.parent : null;
    }

    private RBNode leftOf(RBNode node) {
        return node != null ? node.left : null;
    }

    private RBNode rightOf(RBNode node) {
        return node != null ? node.right : null;
    }

    public void put(K key, V value) {
        if (this.root == null) {
            root = new RBNode(key, value == null ? (V) key : value, null);
            return;
        }
        if (key == null) return;
        RBNode node = this.root;
        RBNode parent = null;
        int cmp = 0;
        do {
            parent = node;
            cmp = key.compareTo((K) node.key);
            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {
                node.setValue(value == null ? (V) key : value);
                return;
            }
        } while (node != null);

        RBNode e = new RBNode(key, value == null ? (V) key : value, parent);
        if (cmp < 0) {
            parent.left = e;
        } else {
            parent.right = e;
        }

        fixAfterPut(e);
    }

    //插入调整
    private void fixAfterPut(RBNode x) {
        setColor(x, RED);
        //因为会向上传递，当x传递到root的时候就直接退出
        while (x != null && x != root && x.parent.color == RED) {
            //父节点为爷节点的左孩子
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                //看叔叔节点是否也为红
                RBNode uncle = rightOf(parentOf(parentOf(x)));
                if (colorOf(uncle) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(uncle, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    //正因为这个，x才有可能为null，所以在while循环的时候需要加x != null
                    x = parentOf(parentOf(x));
                } else {
                    //如果插入节点是父节点的右，统一弄到左边
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        leftRotate(x);
                    }
                    //全部到左边后，右旋
                    setColor(parentOf(parentOf(x)), RED);
                    setColor(parentOf(x), BLACK);
                    rightRotate(parentOf(parentOf(x)));
                }
            } else {
                RBNode uncle = leftOf(parentOf(parentOf(x)));
                if (colorOf(uncle) == RED) {
                    setColor(uncle, BLACK);
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rightRotate(x);
                    }
                    setColor(parentOf(parentOf(x)), RED);
                    setColor(parentOf(x), BLACK);
                    leftRotate(parentOf(parentOf(x)));
                }
            }
        }
        setColor(root, BLACK);
    }

    //删除操作
    public V remove(K key) {
        RBNode node = getNode(key);
        if (node == null) return null;
        V oldValue = node.value;
        deleteNode(node);
        return oldValue;
    }

    private void deleteNode(RBNode node) {
        //如果左右节点都有说明有后继
        if (node.left != null && node.right != null) {
            RBNode successor = successor(node);
            node.key = successor.key;
            node.value = successor.value;
            //这里将后继赋值给node，下一步要删除后继，需要找后继的替代节点
            node = successor;
        }
        RBNode replacement = node.left == null ? node.right : node.left;
        //如果有替代者，必在234树对应的叶子节点，且替代者必红
        if (replacement != null) {
            replacement.parent = parentOf(node);
            if (node == root) {
                root = replacement;
            } else if (leftOf(parentOf(node)) == node) {
                parentOf(node).setLeft(replacement);
            } else {
                parentOf(node).setRight(replacement);
            }
            node.parent = node.left = node.right = null;
            if (colorOf(node) == BLACK) {
                setColor(replacement, BLACK);
            }
        }
        //如果这个树只有一个根节点，且恰好删除的就是根节点
        else if (node == root) {
            root = null;
        }
        //此时node为叶子节点
        else {
            //如果为黑色节点，需要调整，如果为红色，则直接删除
            if (colorOf(node) == BLACK) {
                //先调整，再删除
                fixAfterRemove(node);
            }

            //删除节点
            if (node.parent != null) {
                if (leftOf(parentOf(node)) == node) {
                    parentOf(node).left = null;
                } else {
                    parentOf(node).right = null;
                }
                node.parent = null;
            }
        }
    }

    //节点为黑色
    private void fixAfterRemove(RBNode node) {
        while (node != root && node.color == BLACK) {
            if (node == leftOf(parentOf(node))) {
                RBNode brother = rightOf(parentOf(node));
                //brother如果为红色，说明不是真的brother，因为只针对黑色节点进行调整
                //根本原因是234树三节点转换成红黑树的时候有两种方案，所以只需旋转转成另外一种兄弟节点就是黑色的了
                if (colorOf(brother) == RED) {
                    setColor(parentOf(node), RED);
                    setColor(brother, BLACK);
                    leftRotate(parentOf(node));
                    brother = rightOf(parentOf(node));
                }
                //这种情况说明brother要么不存在，要么brother没有红色节点可以借
                if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) {
                    setColor(brother, RED);
                    node = parentOf(node);
                }
                //可以找兄弟借
                else {
                    //错误：如果兄弟节点的唯一孩子在左边的话，先调整到右边
                    //现在的情况是知道兄弟节点可以借，但是不知道是左孩子有红色还是右孩子有红色还是左右孩子都有红色，所以
                    //仔细想一想，这样子写是不是很妙
                    if (colorOf(rightOf(brother)) == BLACK) {
                        setColor(brother, RED);
                        setColor(leftOf(brother), BLACK);
                        rightRotate(brother);
                        brother = rightOf(parentOf(node));
                    }
                    //左旋
                    setColor(brother, colorOf(parentOf(node)));
                    setColor(parentOf(node), BLACK);
                    setColor(rightOf(brother), BLACK);
                    leftRotate(parentOf(node));
                    //结束
                    node = root;
                }
            } else {
                RBNode brother = leftOf(parentOf(node));
                if (colorOf(brother) == RED) {
                    setColor(brother, BLACK);
                    setColor(parentOf(node), RED);
                    rightRotate(parentOf(node));
                    brother = leftOf(parentOf(node));
                }
                if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) {
                    setColor(brother, RED);
                    node = parentOf(node);
                } else {
                    if (colorOf(rightOf(brother)) == BLACK) {
                        setColor(brother, RED);
                        setColor(rightOf(brother), BLACK);
                        leftRotate(brother);
                        brother = leftOf(parentOf(node));
                    }
                    setColor(brother, colorOf(parentOf(node)));
                    setColor(parentOf(node), BLACK);
                    setColor(leftOf(brother), BLACK);
                    rightRotate(parentOf(node));
                    node = root;
                }
            }
        }

        setColor(node, BLACK);
    }

    class RBNode {
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        K key;
        V value;

        public RBNode() {
        }

        public RBNode(K key, V value, RBNode parent) {
            this.parent = parent;
            this.color = BLACK;
            this.key = key;
            this.value = value;
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}