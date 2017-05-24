package com.lucifer.spitter.data;

import com.lucifer.spitter.Spittle;
import java.util.List;

public interface SpittleRepository {
    /**
     * @param max
     *            待返回的最大的Spittle ID
     * @param count
     *            返回Spittle对象的个数
     * @return
     */
    List<Spittle> findSpittles(long max, int count);

    List<Spittle> findRecentSpittles();

    Spittle findOne(long spittleId);

    void save(Spittle spittle);
}
