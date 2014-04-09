
$ ->
  $('#menu li').hover ->
    $(@).children('ul').show()
  ,->
    $(@).children('ul').hide()