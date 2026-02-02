let currentMood="";

const home=document.getElementById("home");
const player=document.getElementById("player");
const video=document.getElementById("video");
const emoji=document.getElementById("moodEmoji");
const title=document.getElementById("moodTitle");

document.querySelectorAll(".mood").forEach(card=>{
  card.onclick=()=>{
    currentMood=card.dataset.mood;
    emoji.innerText=card.firstChild.textContent;
    title.innerText=currentMood.toUpperCase()+" VIBES";
    home.style.display="none";
    player.style.display="block";
    loadSong();
  }
});

async function loadSong() {
  try {
    const response = await fetch(`/songs/recommend/${currentMood}`);
    const song = await response.json();

    video.src = `https://www.youtube.com/embed/${song.videoId}?autoplay=1&mute=1`;
    video.onerror = () => {
        window.open(`https://www.youtube.com/watch?v=${song.videoId}`, "_blank");
    }
  } catch (e) {
    alert("Unable to load song");
  }
}

document.getElementById("newSong").onclick=loadSong;
document.getElementById("back").onclick=()=>{
  video.src="";
  player.style.display="none";
  home.style.display="block";
};
