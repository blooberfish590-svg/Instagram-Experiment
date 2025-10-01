const popup = document.getElementById('popup');
const popupImg = document.getElementById('popup-img');
const popupStats = document.getElementById('popup-stats');
let selectedPost = 0;
let didLike = false;
let didShare = false;

const images = [
  '',
  'images/iStock-1014791492-1.jpg',
  'images/1444.jpg',
  'images/croatie-plivitche-cascade.jpg'
];

const stats = [
  '',
  '6,820 likes • 420 comments • 153 shares', // Post 1 (high popularity)
  '5,940 likes • 388 comments • 102 shares', // Post 2 (high popularity)
  '462 likes • 19 comments • 3 shares'       // Post 3 (low popularity)
];

// Google Form entry IDs for your survey
const entryIds = {
  like: 'entry.101173465',
  comment: 'entry.1696572370',
  share: 'entry.1329892506',
  popularityHigh: 'entry.71574771',
  popularityLow: 'entry.861841110'
};

function openPopup(postId) {
  selectedPost = postId;
  didLike = false;
  didShare = false;
  document.getElementById('commentInput').value = '';
  popupImg.src = images[postId];
  popupStats.innerText = stats[postId];
  popup.style.display = 'flex';
}

function closePopup() {
  popup.style.display = 'none';
}

function likePost() {
  didLike = true;
  alert("You liked this post ❤️");
}

function sharePost() {
  didShare = true;
  alert("You shared this post 🔁");
}

function submitForm() {
  const comment = document.getElementById('commentInput').value.trim();
  let url = 'https://docs.google.com/forms/d/e/1FAIpQLSffRo_iBkQpoZs4tBHE8XsbQjCDoqQDUphDQMfcxfHSqJxS6A/viewform?usp=pp_url&';

  if (didLike) url += `${entryIds.like}=Like&`;
  if (didShare) url += `${entryIds.share}=Share&`;
  if (comment) url += `${entryIds.comment}=${encodeURIComponent(comment)}&`;

  if (selectedPost === 3) {
    url += `${entryIds.popularityLow}=Low`;
  } else {
    url += `${entryIds.popularityHigh}=High`;
  }

  window.open(url, '_blank');
}
