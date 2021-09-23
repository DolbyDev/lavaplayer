package com.sedmelluq.discord.lavaplayer.track;

import java.util.List;

/**
 * The basic implementation of AudioPlaylist
 */
public class BasicAudioPlaylist implements AudioPlaylist {
  private final String name;
  private final String author;
  private final String authorUrl;
  private final String image;
  private final List<AudioTrack> tracks;
  private final AudioTrack selectedTrack;
  private final boolean isSearchResult;

  /**
   * @param name Name of the playlist
   * @param author Author name of the playlist
   * @param authorUrl Author url of the playlist
   * @param image Image of the playlist
   * @param tracks List of tracks in the playlist
   * @param selectedTrack Track that is explicitly selected
   * @param isSearchResult True if the playlist was created from search results
   */
  public BasicAudioPlaylist(String name, String author, String authorUrl, String image, List<AudioTrack> tracks, AudioTrack selectedTrack, boolean isSearchResult) {
    this.name = name;
    this.author = author;
    this.authorUrl = authorUrl;
    this.image = image;
    this.tracks = tracks;
    this.selectedTrack = selectedTrack;
    this.isSearchResult = isSearchResult;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getAuthor() {
    return author;
  }

  @Override
  public String getAuthorUrl() {
    return authorUrl;
  }

  @Override
  public String getImage() {
    return image;
  }

  @Override
  public List<AudioTrack> getTracks() {
    return tracks;
  }

  @Override
  public AudioTrack getSelectedTrack() {
    return selectedTrack;
  }

  @Override
  public boolean isSearchResult() {
    return isSearchResult;
  }
}
