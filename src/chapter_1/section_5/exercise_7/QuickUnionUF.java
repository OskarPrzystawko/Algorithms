package chapter_1.section_5.exercise_7;

/**
 * N - nodes amount
 *
 * Worst case time complexity
 *  Union() / Find() - N
 *
 * Best case time complexity
 *  Union() / Find() - 1
 */
public class QuickUnionUF extends UnionFindNodeIndexed {

    public QuickUnionUF(int nodesAmount) {
        super(nodesAmount);
    }

    @Override
    public int find(int p) {
        while(p != nodeToIdMap[p]) {
            p = nodeToIdMap[p];
        }
        return p;
    }


    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        nodeToIdMap[pId] = qId;
        componentsAmount--;
    }

}
