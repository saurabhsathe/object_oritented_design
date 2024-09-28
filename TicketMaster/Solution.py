"""
Requirements
Write code for low level design of a movie ticket booking system like BookMyShow.
System has cinemas located in different cities. Each cinema will have multiple screens, and users can book one or more seats in given movie show.

System should be able to add new cinemas and movie shows in those cinemas.
Users should be able to list all cinema's in their city which are displaying a particular movie.
For a given cinema, users should also be able to list all shows which are displaying a particular movie.


"""

"""
Models:

1) Movies
2) Shows
4) Cinemas
5) Cache

Services
System Service - controllers
Cinema Service -  responsible for creating a cinema, deleting it
Movie manager service -  get movies at a time, add movies,get shows for a movie

"""
#
# class Movie:
#
#     def __init__(self,movie_name,show, screen):
#         self.movie_name= movie_name
#         self.show = show
#         self.screen = screen
#
#
#
# class Show:
#     def __init__(self,show_time,screen, cinema):
#         self.show_time= show_time
#         self.screen = screen
#         self.cinema = cinema
# class Screen:
#     def __init__(self,screen_type,cinema):
#         self.screen_type= screen_type
#         self.cinema = cinema
#
#
# class Cinema:
#     def __init__(self,name,city):
#         self.name = name
#         self.city = city
#         self.screens=[]
#
#     def addScreen(self,screen):
#         self.screens.append(screen)
#
# data= {
#     "cinemas":[("AMC","Pune")],
#     "screens":[["xd","standard","xd"]],
#     "shows":[[[("11:30","2:30","AM"),("11:30","2:30","AM")],[("9:30","11:30","PM")]]],
#     "movies":[["Avengers","Batman","Batman"]]
#
#
# }
# class CinemaBuilder:
#
#     def __build_screens__(self,cinema,screens):
#         for screen in screens:
#             screen_obj = Screen(screen,cinema)
#             cinema.addScreen(screen_obj)
#     def
#
#
#     def __build__(self,data):
#         for i,(cinema,city) in enumerate(data["cinemas"]):
#             cinema_obj = Cinema(cinema,city)
#
#
#
#     def build_cinema(self,name, data):
#
