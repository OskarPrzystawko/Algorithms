package chapter_1.section_5.exercise_7;

/**
 * N - nodes amount
 * <p>
 * Time complexity (every case)
 *  Union() - N
 *  Find() - 1
 */
public class QuickFindUF extends UnionFindNodeIndexed {

    public QuickFindUF(int nodesAmount) {
        super(nodesAmount);
    }

    @Override
    public int find(int p) {
        return nodeToIdMap[p];
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < nodeToIdMap.length; i++) {
            if (nodeToIdMap[i] == pId) {
                nodeToIdMap[i] = qId;
            }
        }

        componentsAmount--;
    }

}
