package dao.daoImpl;

import dao.FavoriteDao;
import datebase.DateBase;
import models.Announcement;
import models.Favorite;
import models.User;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {

    @Override
    public String addToFavorite(Long userId, Long announcementId,Favorite favorite) {
//        DateBase.users.stream().filter(user -> user.getId().equals(userId)).findFirst().
//                ifPresent(user -> user.getAnnouncements().stream()
//        .filter(announcement -> announcement.getId().equals(announcementId))
//                .findFirst().orElse(null));
//        return "success";
        for (User user : DateBase.users) {
            if (userId.equals(user.getId())) {
                for (Announcement announcement : user.getAnnouncements()) {
                    if (announcementId.equals(announcement.getId())) {
                        user.setFavorites(List.of(favorite));
                    }
                }
            }
        }return null;
    }

    @Override
    public String deleteFavoritebyId(Long userId, Long favoriteId) {
        DateBase.users.stream().filter(user -> user.getId().equals(userId)).findFirst().ifPresent(user -> user.
                getFavorites().removeIf(favorite -> favorite.getId().equals(favoriteId)));

        return "success";
    }

    @Override
    public Favorite getFavoriteByID(Long userId, Long favoriteId) {
        for (User user : DateBase.users) {
            if (user.getId().equals(userId)) {
                for (Favorite favorite : user.getFavorites()) {
                    if (favorite.getId().equals(favoriteId)) {
                        return favorite;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Favorite> getAllFavoriteByUserId(Long userId) {
    for (User user : DateBase.users) {
        if (user.getId().equals(userId)) {
            return user.getFavorites();
        }
    }
    return null;
    }
}