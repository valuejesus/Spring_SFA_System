package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUser;

/**
 * DBへのアクセスメソッドを呼び出すDao
 * @author aoi
 *
 */
@Repository
public class LoginUserDao {

    /**
     * エンティティを管理するオブジェクト。
     * 以下のメソッドでエンティティクラスであるLoginUserにキャストして戻り値を返すので必要なオブジェクト。
     */
    @Autowired
    EntityManager em;

    /**
     * フォームの入力値から該当するユーザを検索 合致するものが無い場合Nullが返される
     * @param userName
     * @return 一致するユーザが存在するとき:UserEntity、存在しないとき:Null
     */
    public LoginUser findUser(String userName) {

        String query = "";
        query += "SELECT * ";
        query += "FROM user_info ";
        query += "WHERE user_name = :userName "; //setParameterで引数の値を代入できるようにNamedParameterを利用

        //EntityManagerで取得された結果はオブジェクトとなるので、LoginUser型へキャストが必要となる
        return (LoginUser)em.createNativeQuery(query, LoginUser.class).setParameter("userName", userName).getSingleResult();
    }

}


