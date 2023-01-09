from pytube import YouTube
from pytube import Playlist
import os

def DownloadURL(URL="https://www.youtube.com/playlist?list=PLwTJnMf704hc4psc9jisCEwPUSgFwWjCZ"):
    #playlist = Playlist("https://www.youtube.com/playlist?list=PLwTJnMf704hc4psc9jisCEwPUSgFwWjCZ")
    #URL="https://www.youtube.com/watch?v=f_Bt4Vg94Ug"
    #URL="https://www.youtube.com/playlist?list=PLwTJnMf704hc4psc9jisCEwPUSgFwWjCZ"
    
    playlist = Playlist(URL)

    for url in playlist:
       yt = YouTube(url)

       # extract only audio
       video = yt.streams.filter(only_audio=True).first()

       # replace destination with the path where you want to save the downloaded file

       # destination = "C:/Users/jaber/Desktop"

       # download the file
       out_file = video.download()

       # save the file
       base, ext = os.path.splitext(out_file)
       new_file = base + '.mp3'
       os.rename(out_file, new_file)

       
   


