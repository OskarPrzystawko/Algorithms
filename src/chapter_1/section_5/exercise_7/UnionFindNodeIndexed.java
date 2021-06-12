package chapter_1.section_5.exercise_7;

abstract public class UnionFindNodeIndexed implements UnionFind {

    protected int[] nodeToIdMap;
    protected int componentsAmount;

    public UnionFindNodeIndexed(int nodesAmount) {
        componentsAmount = nodesAmount;
        nodeToIdMap = new int[nodesAmount];

        for(int i = 0; i < nodesAmount; i++) {
            nodeToIdMap[i] = i;
        }
    }

    @Override
    public boolean areConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getComponentsAmount() {
        return componentsAmount;
    }

}
