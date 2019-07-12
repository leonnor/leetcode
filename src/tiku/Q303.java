package tiku;

/**
 * className Q303
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019/6/28 16:00
 */
public class Q303 {

    class NumArray {

        private interface Merger<E> {

            E merge(E a, E b);
        }

        private class SegmentTree<E> {

            /**
             * 把线段树看成满二叉树的表示
             */
            private E[] tree;
            private E[] data;
            /**
             * 用于定义线段树的两个区间是如何融合的
             */
            private Merger<E> merger;

            public SegmentTree(E[] arr, Merger<E> merger){

                this.merger = merger;

                data = (E[])new Object[arr.length];
                for (int i = 0; i < arr.length; i++){
                    data[i] = arr[i];
                }

                tree = (E[])new Object[4 * arr.length];
                buildSegmentTree(0, 0, data.length - 1);
            }

            /**
             * 在treeIndex的位置创建表示区间[l...r]的线段树
             * @param treeIndex
             * @param l
             * @param r
             */
            private void buildSegmentTree(int treeIndex, int l, int r){

                if (l == r){
                    tree[treeIndex] = data[l];
                    return;
                }

                int leftTreeIndex = leftChild(treeIndex);
                int rightTreeIndex = rightChild(treeIndex);

                /**
                 * 这样写避免l+r超出整型范围
                 */
                int mid = l + (r - l) / 2;
                /**
                 * 递归创建左右子树
                 */
                buildSegmentTree(leftTreeIndex, l, mid);
                buildSegmentTree(rightTreeIndex, mid + 1, r);

                tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
            }

            public int getSize(){
                return data.length;
            }

            public E get(int index){
                if (index < 0 || index >= data.length){
                    throw new IllegalArgumentException("Index is illegal.");
                }
                return data[index];
            }

            /**
             * 返回左孩子节点索引
             * @param index
             * @return
             */
            private int leftChild(int index){
                return 2 * index + 1;
            }

            /**
             * 返回右孩子节点索引
             * @param index
             * @return
             */
            private int rightChild(int index){
                return 2 * index + 2;
            }

            /**
             * 返回区间[queryL, queryR]的值
             * @param queryL
             * @param queryR
             * @return
             */
            public E query(int queryL, int queryR){

                if (queryL < 0 || queryL >= data.length ||
                        queryR < 0 || queryR >= data.length || queryL > queryR){
                    throw new IllegalArgumentException("Index is illegal.");
                }
                return query(0, 0, data.length - 1, queryL, queryR);
            }

            /**
             * 在以treeIndex为根的线段树中[l,r]的范围里，搜索区间[queryL,queryR]的值
             * @param treeIndex
             * @param l
             * @param r
             * @param queryL
             * @param queryR
             * @return
             */
            private E query(int treeIndex, int l, int r, int queryL, int queryR){

                /**
                 * 递归终止条件
                 */
                if (l == queryL && r == queryR){
                    return tree[treeIndex];
                }

                int mid = l + (r - l) / 2;
                int leftTreeIndex = leftChild(treeIndex);
                int rightTreeIndex = rightChild(treeIndex);

                /**
                 * 查询区间只在左孩子或右孩子中的情况
                 */
                if (queryL >= mid + 1){
                    return query(rightTreeIndex, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid){
                    return query(leftTreeIndex, l, mid, queryL, queryR);
                }

                /**
                 * 查询区间同时分布于左右孩子的情况
                 */
                E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
                E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
                return merger.merge(leftResult, rightResult);
            }
        }

        private SegmentTree<Integer> segmentTree;

        public NumArray(int[] nums) {

            if (nums.length > 0){
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++){
                    data[i] = nums[i];
                }
                segmentTree = new SegmentTree<>(data, ((a, b) -> a + b));
            }
        }

        public int sumRange(int i, int j) {

            if(segmentTree == null){
                throw new IllegalArgumentException("");
            }
            return segmentTree.query(i, j);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
