/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IRoom;
import bkap.mapper.RoomMapper;
import bkap.model.Room;
import java.util.List;

/**
 *
 * @author THUY
 */
public class RoomDAO extends AbstractDAO<Room> implements IRoom{

    @Override
    public void add(Room r) {
        String sql = "{call room_insert(?,?,?,?,?)}";
        insert(sql, r.getRoomId(), r.getType(), r.getImage(), r.getDescript(), r.getStatus());
    }

    @Override
    public void edit(Room r) {
        String sql = "{call roomm_update(?,?,?,?,?)}";
        update(sql, r.getRoomId(), r.getType(), r.getImage(), r.getDescript(), r.getStatus());
    }

    @Override
    public void delete(int roomId) {
        String sql = "{call room_delete(?)}";
        update(sql, roomId);
    }

    @Override
    public List<Room> findAll() {
        String sql = "{call room_findAll()}";
        return query(sql, new RoomMapper());
    }
    
}
