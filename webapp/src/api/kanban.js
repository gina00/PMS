import request from '@/utils/request'

export function addKanban(data) {
  return request({
    url: '/paas/kanban/', 
    method: 'post',
    data
  })
}

export function getList() {
  return request({
    url: '/paas/kanban/list', 
    method: 'get'
  })
}

export function deleteKanban(data) {
  return request({
    url: '/paas/kanban/delete', 
    method: 'post',
    data
  })
}


