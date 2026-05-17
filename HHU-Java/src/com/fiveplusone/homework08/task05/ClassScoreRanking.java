package com.fiveplusone.homework08.task05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class ClassScoreRanking {

    public static void main(String[] args) {
        // 1. 创建 ArrayList<ScoreRecord> 保存成绩数据
        List<ScoreRecord> scoreList = new ArrayList<>();
        scoreList.add(new ScoreRecord("2026001", "林羽", 88.5));
        scoreList.add(new ScoreRecord("2026002", "陈星", 92.0));
        scoreList.add(new ScoreRecord("2026003", "苏畅", 76.5));
        scoreList.add(new ScoreRecord("2026004", "王宇", 92.0)); // 与陈星分数相同
        scoreList.add(new ScoreRecord("2026005", "李然", 81.0));
        scoreList.add(new ScoreRecord("2026006", "赵晴", 95.5));

        // 打印原始成绩（要求至少调用一次泛型方法）
        System.out.println("【原始成绩】");
        printCollection(scoreList);
        System.out.println();

        // 2. 排序：分数从高到低，分数相同则按学号升序
        // 这里使用 List 接口自带的 sort 方法（底层也会调用 Arrays.sort）
        scoreList.sort((s1, s2) -> {
            // 先按分数降序比较（注意这里是 s2 和 s1 比较）
            int scoreCompare = Double.compare(s2.getScore(), s1.getScore());
            if (scoreCompare != 0) {
                return scoreCompare;
            }
            // 分数相同，按学号升序比较（s1 和 s2 比较）
            return s1.getStudentId().compareTo(s2.getStudentId());
        });

        // 打印成绩排行榜
        System.out.println("【成绩排行榜】");
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.println("第" + (i + 1) + "名：" + scoreList.get(i));
        }
        System.out.println();

        // 3. 找出最高分和最低分记录
        // 为了让 max 和 min 正常工作，我们需要提供一个“自然升序”（仅按分数从低到高）的比较器
        Comparator<ScoreRecord> scoreAscComparator = Comparator.comparingDouble(ScoreRecord::getScore);

        ScoreRecord maxRecord = Collections.max(scoreList, scoreAscComparator);
        ScoreRecord minRecord = Collections.min(scoreList, scoreAscComparator);

        System.out.println("最高分：" + maxRecord.getName() + " " + maxRecord.getScore());
        System.out.println("最低分：" + minRecord.getName() + " " + minRecord.getScore());
        System.out.println();

        // 4. 随机打乱学生名单，模拟课堂抽查
        Collections.shuffle(scoreList);

        System.out.println("【随机抽查顺序】");
        StringJoiner joiner = new StringJoiner("、");
        for (ScoreRecord record : scoreList) {
            joiner.add(record.getName());
        }
        System.out.println(joiner.toString());
    }

    /**
     * 泛型方法：用于统一打印不同类型的集合内容
     *
     * @param collection 实现了 Collection 接口的任意集合
     * @param <T>        集合中元素的类型
     */
    public static <T> void printCollection(Collection<T> collection) {
        for (T item : collection) {
            System.out.println(item);
        }
    }
}